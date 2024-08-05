package org.example.kingcrabback.domain.user.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.mypage.dto.UserMyPageReadResponse;
import org.example.kingcrabback.domain.user.mypage.dto.UserMyPageUpdateRequest;
import org.example.kingcrabback.domain.user.mypage.service.UserMyPageReadService;
import org.example.kingcrabback.domain.user.mypage.service.UserMyPageUpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class UserMyPageController {

    private final UserMyPageUpdateService userMyPageUpdateService;
    private final UserMyPageReadService userMyPageReadService;

    @GetMapping("/read")
    public UserMyPageReadResponse userMyPageRead() {
        return userMyPageReadService.userMyPageRead();
    }

    @PatchMapping("/update/{newUserName}")
    public void userMyPageUpdate(@PathVariable String newUserName) {
        userMyPageUpdateService.userMyPageUpdateService(newUserName);
    }
}
