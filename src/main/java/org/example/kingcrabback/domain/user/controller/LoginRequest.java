package org.example.kingcrabback.domain.user.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {
    private String userName;
    private String password;
}
