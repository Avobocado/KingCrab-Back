package org.example.kingcrabback.domain.user.mypage.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.exception.UserNotFoundException;
import org.example.kingcrabback.domain.user.facade.UserFacade;
import org.example.kingcrabback.domain.user.mypage.dto.UserMyPageUpdateRequest;
import org.example.kingcrabback.domain.user.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserMyPageUpdateService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void userMyPageUpdateService(String username) {
        User user = userRepository.findByUserName(userFacade.getCurrentUser().getUserName())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
        user.update(username);
        userRepository.save(user);
    }
}
