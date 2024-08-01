package org.example.kingcrabback.domain.utill.jwt.auth;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.repository.UserRepository;
import org.example.kingcrabback.domain.utill.jwt.auth.AuthDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {
    private final UserRepository userFacade;

    @Override
    public UserDetails loadUserByUsername(String email) {
        return new AuthDetails(userFacade.findByUserName(email).orElseThrow(()-> new RuntimeException("asdf")));
    }
}