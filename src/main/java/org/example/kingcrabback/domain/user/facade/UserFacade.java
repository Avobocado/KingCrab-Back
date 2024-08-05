package org.example.kingcrabback.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.exception.UserNotFoundException;
import org.example.kingcrabback.domain.user.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        return userRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(()->UserNotFoundException.EXCEPTION);
    }

}
