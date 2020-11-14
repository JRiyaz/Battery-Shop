package com.batteryshop.controller;

import com.batteryshop.entity.PermissionsEntity;
import com.batteryshop.entity.UserEntity;
import com.batteryshop.model.UserRole;
import com.batteryshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
//    private final MailService mailService;

    private static String generateOtp(int otpLength) {

        var random = new SplittableRandom();
        var builder = new StringBuilder();

        IntStream.range(0, otpLength)
                .forEach(num -> builder.append(random.nextInt(0, 9)));
        return builder.toString();
    }

    @GetMapping("all")
    public String allUsers(Model model) {

        model.addAttribute("users", userService.findAll());
        return "all-users";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("register")
    public String register(Model model) {

        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("sign-up")
    public String signUp(@ModelAttribute("user") UserEntity userEntity) {

        userEntity.setAccountNonExpired(false)
                .setAccountNonLocked(false)
                .setAccountNonLocked(false)
                .setCredentialsNonExpired(false)
                .setUserRole(UserRole.ROLE_USER)
                .setEnabled(false)
                .setPermissions(userEntity.getUserRole()
                        .getPermissions()
                        .stream()
                        .map(PermissionsEntity::new)
                        .collect(Collectors.toList()))
                .setPassword(passwordEncoder.encode(userEntity.getPassword()));

        final var user = userService.save(userEntity);

        System.err.println("From sign-up: " + user);

//        Map<String, Object> model = new HashMap<>();
//        var mailRequest = new MailRequest(user.getEmail(),
//                "j.riyazu@gmail.com",
//                "janupavaripalliriyaz@gmail.com",
//                "Registration Successful",
//                generateOtp(6));

//        model.put("Name", mailRequest.getName());
//        model.put("location", "Bangalore,India");
//        model.put("otp", mailRequest.getOtp());
//        mailService.sendEmail(mailRequest, model);

        return "redirect: /user/login?register=success";
    }

    @GetMapping("update")
    public String updateUser(@RequestParam Integer userId, Model model) {

        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("roles", List.of(UserRole.values()));
        model.addAttribute("conditions", Arrays.asList(true, false));
        return "update-user";
    }

    @PostMapping("update/{userId}")
    public String updateUser(@PathVariable Integer userId, @ModelAttribute UserEntity userEntity) {

        Integer user_id = userService.findById(userId).get().getId();

        var user = userEntity;
        user.setId(userId)
                .setAccountNonLocked(userEntity.getIsAccountNonLocked())
                .setAccountNonExpired(userEntity.getIsAccountNonExpired())
                .setCredentialsNonExpired(userEntity.getIsCredentialsNonExpired())
                .setEnabled(userEntity.getIsEnabled())
                .setPermissions(user.getUserRole()
                        .getPermissions()
                        .stream()
                        .map(PermissionsEntity::new)
                        .collect(Collectors.toList()));


        if (userEntity.getPassword().length() < 10)
            user.setPassword(passwordEncoder.encode(user.getPassword()));

        System.err.println("From update-user post: " + user);

        userService.save(user);

//        Map<String, Object> model = new HashMap<>();
//        var mailRequest = new MailRequest(user.getName(),
//                "j.riyazu@gmail.com",
//                "janupavaripalliriyaz@gmail.com",
//                "Your Account Activated",
//                generateOtp(6));
//
//        model.put("Name", mailRequest.getName());
//        model.put("location", "Bangalore,India");
//        model.put("otp", mailRequest.getOtp());
//        mailService.sendEmail(mailRequest, model);

        return "redirect: /user/all?alert=updated-" + userId;
    }
}
