package com.batteryshop.security;

import com.batteryshop.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ApplicationUserDetails implements UserDetails {

    private final UserEntity userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = userEntity.getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission().name()))
                .collect(Collectors.toList());
        grantedAuthorities.add(new SimpleGrantedAuthority(userEntity.getUserRole().name()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userEntity.getIsAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userEntity.getIsAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userEntity.getIsCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userEntity.getIsEnabled();
    }
}
