package com.domus.net.web.model;

public record AuthCreateUser(String username, String password,Long personId, AuthCreateRoleRequest authCreateRoleRequest) {
}
