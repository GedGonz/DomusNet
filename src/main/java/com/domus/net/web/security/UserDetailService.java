package com.domus.net.web.security;


import com.domus.net.application.RoleApplication;
import com.domus.net.application.UserApplication;
import com.domus.net.domain.dto.PersonDto;
import com.domus.net.domain.dto.RoleDto;
import com.domus.net.domain.dto.UserDto;
import com.domus.net.infrastructure.enums.TypeStateEnum;
import com.domus.net.web.model.AuthCreateUser;
import com.domus.net.web.model.AuthLoginRequest;
import com.domus.net.web.model.AuthResponse;
import com.domus.net.web.security.util.JwtUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailService implements UserDetailsService {

	private final PasswordEncoder passwordEncoder;
	private final JwtUtils jwtUtils;
	private final UserApplication userApplication;
	private final RoleApplication roleApplication;

	public UserDetailService( JwtUtils jwtUtils, PasswordEncoder passwordEncoder, UserApplication userApplication, RoleApplication roleApplication) {
		this.userApplication = userApplication;
		this.roleApplication = roleApplication;
		this.jwtUtils = jwtUtils;
		this.passwordEncoder=passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
			authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

			UserDto user = userApplication.getByUsername(username);

			user.getRoles().forEach(roleDto ->
					authorityList.add(new SimpleGrantedAuthority("ROLE_"+roleDto.getRoleEnum().name()))
			);

			user.getRoles().stream().flatMap(role->role.getPermissions().stream()).forEach(permissionDto ->
					authorityList.add(new SimpleGrantedAuthority(permissionDto.getName()))
			);

			return new User(user.getUsername(),
					user.getPassword(),
					user.isEnabled(),
					user.isAccountNoExpired(),
					user.isCredentialNoExpired(),
					user.isAccountNoLocked(),authorityList);

		} catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("User not found!");
		}
	}

	public AuthResponse loginUser(AuthLoginRequest authLoginRequest){
		String username = authLoginRequest.username();
		String password = authLoginRequest.password();

		Authentication authentication = authenticate(username,password);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtUtils.createToken(authentication);

		return new AuthResponse(username,"User loged successfully",token,true);

	}

	public Authentication authenticate(String username, String password){
		UserDetails userDetails = this.loadUserByUsername(username);

		if(userDetails==null) throw  new BadCredentialsException("Invalid username or password");

		if(!passwordEncoder.matches(password, userDetails.getPassword())) throw  new BadCredentialsException("Invalid username or password");

		return new UsernamePasswordAuthenticationToken(username,userDetails.getPassword(),userDetails.getAuthorities());
	}

	public AuthResponse createUser(AuthCreateUser authCreateUser){

		String username = authCreateUser.username();
		String password = authCreateUser.password();
		List<String> roles = authCreateUser.authCreateRoleRequest().roleListName();

		Set<RoleDto> rolesSet= new HashSet<>(roleApplication.findRoleByRoleEnumIn(roles));

		if(rolesSet.isEmpty())
			throw  new IllegalArgumentException("roles not exist!");

		UserDto user = UserDto.builder().
				username(username).
				password(passwordEncoder.encode(password)).
				person(PersonDto.builder().id(authCreateUser.personId()).build()).
				state(TypeStateEnum.ACTIVE).
				roles(rolesSet).
				enabled(true).
				accountNoLocked(true).
				accountNoExpired(true).
				credentialNoExpired(true).
				build();

		UserDto userCreated = userApplication.save(user);


		List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

		userCreated.getRoles().forEach(roleDto ->
				authorityList.add(new SimpleGrantedAuthority("ROLE_"+roleDto.getRoleEnum().name()))
		);

		userCreated.getRoles().stream().flatMap(role->role.getPermissions().stream()).forEach(permissionDto ->
				authorityList.add(new SimpleGrantedAuthority(permissionDto.getName()))
		);

		Authentication authentication = new UsernamePasswordAuthenticationToken(username,null,authorityList);

		String token = jwtUtils.createToken(authentication);

		return new AuthResponse(userCreated.getUsername(), "User created successfully",token,true);
	}
}
