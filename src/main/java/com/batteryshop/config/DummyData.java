package com.batteryshop.config;

import com.batteryshop.entity.PermissionsEntity;
import com.batteryshop.entity.UserEntity;
import com.batteryshop.service.StudentService;
import com.batteryshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.batteryshop.model.UserRole.ROLE_ADMIN;

@Component
@AllArgsConstructor
public class DummyData implements CommandLineRunner {

    private final StudentService service;
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {

//        $2a$10$7CKO/oW44oSnvVvuYTGMh.X.Rp6poru.xn1QulhovmBzME/RaGFS2  - 10 -  1234

        userService.saveAll(
                Arrays.asList(
                        new UserEntity("j.riyazu@gmail.com",
                                "$2a$10$7CKO/oW44oSnvVvuYTGMh.X.Rp6poru.xn1QulhovmBzME/RaGFS2",
                                null,
                                true,
                                true,
                                true,
                                true,
                                LocalDateTime.now(),
                                ROLE_ADMIN,
                                null,
                                ROLE_ADMIN.getPermissions()
                                        .stream()
                                        .map(PermissionsEntity::new)
                                        .collect(Collectors.toList())
                        ),
                        new UserEntity("riyazkhan6662@gmail.com",
                                "$2a$10$7CKO/oW44oSnvVvuYTGMh.X.Rp6poru.xn1QulhovmBzME/RaGFS2",
                                null,
                                true,
                                true,
                                true,
                                true,
                                LocalDateTime.now(),
                                ROLE_ADMIN,
                                null,
                                ROLE_ADMIN.getPermissions()
                                        .stream()
                                        .map(PermissionsEntity::new)
                                        .collect(Collectors.toList())
                        )
                )
        );
    }
}
