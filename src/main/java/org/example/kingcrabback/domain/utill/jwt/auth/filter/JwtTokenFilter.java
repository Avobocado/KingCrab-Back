package org.example.kingcrabback.domain.utill.jwt.auth.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.utill.jwt.auth.JwtProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            String token = jwtProvider.resolveToken(request);

            if (token != null) {
                Authentication authentication = jwtProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);
        } catch (RuntimeException e) {
            // 예외 처리: 로그를 남기거나 적절한 응답을 설정
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            // 또는 LOGGER.error("JWT Token Filter error", e);
        }
    }
}
