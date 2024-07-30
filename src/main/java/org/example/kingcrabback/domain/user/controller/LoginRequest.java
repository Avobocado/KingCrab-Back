package org.example.kingcrabback.domain.user.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginRequest {
    private String userName;
    private String password;
}
