package org.example.kingcrabback.domain.user.mypage.service;

import org.example.kingcrabback.domain.user.mypage.dto.UserMyPageReadResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserMyPageReadService {
    public UserMyPageReadResponse userMyPageRead() {
        return new  UserMyPageReadResponse(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
