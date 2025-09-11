package com.domus.net.web.security.config;


import com.domus.net.web.config.filter.JwtTokenValidator;
import com.domus.net.web.security.UserDetailService;
import com.domus.net.web.security.util.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	private final JwtUtils jwtUtils;
	public SecurityConfig(JwtUtils jwtUtils){
		this.jwtUtils=jwtUtils;
	}


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		return httpSecurity
				.csrf(AbstractHttpConfigurer::disable)
				.httpBasic(Customizer.withDefaults()) //habilita la autenticación básica(usuario y contraseña)
				.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
				.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return  authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public AuthenticationProvider authenticationProvider(UserDetailService userDetailService){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailService);
		provider.setPasswordEncoder(passwordEncoder());

		return provider;
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}