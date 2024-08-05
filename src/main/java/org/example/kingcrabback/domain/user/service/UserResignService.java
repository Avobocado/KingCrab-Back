package org.example.kingcrabback.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.exception.UserNotFoundException;
import org.example.kingcrabback.domain.user.facade.UserFacade;
import org.example.kingcrabback.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserResignService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    public void userResign() {
        User user =  userRepository.findByUserName(userFacade.getCurrentUser().getUserName()).orElseThrow(()-> UserNotFoundException.EXCEPTION);
        System.out.println(user.toString());
        userRepository.deleteById(user.getId());
        }

}
