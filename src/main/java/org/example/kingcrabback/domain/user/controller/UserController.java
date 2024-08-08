package org.example.kingcrabback.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.service.UserDuplicateService;
import org.example.kingcrabback.domain.user.service.UserResignService;
import org.example.kingcrabback.domain.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserResignService userResignService;
    private final UserDuplicateService userDuplicateService;
    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody LoginRequest loginRequest) {
        userService.signup(loginRequest);
    }

    @DeleteMapping("/resign")
    public void resign() {
        userResignService.userResign();
    }

    @GetMapping("/duplicate/{username}")
    public boolean duplicate(@PathVariable String username) {
        return userDuplicateService.duplicate(username);
    }
}
