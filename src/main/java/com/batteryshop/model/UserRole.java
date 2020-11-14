package com.batteryshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.batteryshop.model.UserPermission.*;

@AllArgsConstructor
@Getter
public enum UserRole {

    ROLE_GUEST(new ArrayList<>()),
    ROLE_USER(Arrays.asList(READ)),
    ROLE_COUNSELOR(Arrays.asList(READ, WRITE)),
    ROLE_TRAINEE(Arrays.asList(READ, WRITE, UPDATE)),
    ROLE_ADMIN(Arrays.asList(READ, WRITE, UPDATE, DELETE)),
    ROLE_MANAGER(new ArrayList<>());

    private final List<UserPermission> permissions;

    public List<SimpleGrantedAuthority> grantedAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = permissions.stream()
                .map(userPermission -> new SimpleGrantedAuthority(userPermission.name()))
                .collect(Collectors.toList());
        grantedAuthorities.add(new SimpleGrantedAuthority(this.name()));
        return grantedAuthorities;
    }
}
