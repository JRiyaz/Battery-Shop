package com.batteryshop.security;

import com.batteryshop.entity.UserEntity;
import com.batteryshop.exception.UserNotFoundException;
import com.batteryshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByEmailOrMobile(username)
                .orElseThrow(() -> new UserNotFoundException("'" + username + "' not found in the database."));

        return new ApplicationUserDetails(userEntity);
    }
}
