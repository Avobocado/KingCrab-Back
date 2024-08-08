package org.example.kingcrabback.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDuplicateService {
    private final UserRepository userRepository;
    public boolean duplicate(String username) {
        return !(userRepository.existsByUserName(username));
    }
}
