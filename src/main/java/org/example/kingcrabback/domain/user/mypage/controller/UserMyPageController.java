package org.example.kingcrabback.domain.user.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.mypage.service.UserMyPageReadService;
import org.example.kingcrabback.domain.user.mypage.service.UserMyPageUpdateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class UserMyPageController {

    private final UserMyPageUpdateService userMyPageUpdateService;
    private final UserMyPageReadService userMyPageReadService;
}
