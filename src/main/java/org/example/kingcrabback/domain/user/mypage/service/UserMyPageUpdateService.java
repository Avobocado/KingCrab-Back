package org.example.kingcrabback.domain.user.mypage.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.mypage.dto.UserMyPageUpdateRequest;
import org.example.kingcrabback.domain.user.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserMyPageUpdateService {
    private final UserRepository userRepository;

    @Transactional
    public void userMyPageUpdateService(UserMyPageUpdateRequest request) {
        User user = userRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다. "));
        user.update(request.getUsername());
    }
}
