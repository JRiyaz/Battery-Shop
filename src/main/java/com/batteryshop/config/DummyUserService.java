package com.batteryshop.config;

import com.batteryshop.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("dummy")
@AllArgsConstructor
//public class DummyUserService implements UserRepository {
public class DummyUserService {

    private final PasswordEncoder passwordEncoder;

    public Optional<UserModel> findByUsername(String username) {
//        return getUsers().stream()
//                .filter(userModel -> userModel.getUsername().equals(username))
//                .findFirst();
        return null;
    }

//    private List<UserModel> getUsers() {
//        return List.of(
//                new UserModel("user", passwordEncoder.encode("password"),
//                        true, true, true, true,
//                        USER.grantedAuthorities()),
//                new UserModel("counselor", passwordEncoder.encode("password"),
//                        true, true, true, true,
//                        COUNSELOR.grantedAuthorities()),
//                new UserModel("trainee", passwordEncoder.encode("password"),
//                        true, true, true, true,
//                        TRAINEE.grantedAuthorities()),
//                new UserModel("admin", passwordEncoder.encode("password"),
//                        true, true, true, true,
//                        ADMIN.grantedAuthorities())
//        );
//    }
}
