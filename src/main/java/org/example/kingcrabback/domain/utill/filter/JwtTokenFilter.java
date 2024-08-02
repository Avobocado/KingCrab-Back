package org.example.kingcrabback.domain.utill.filter;


import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.utill.jwt.JwtProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            String token = jwtProvider.resolveToken(request);

            if (token == null || !StringUtils.hasText(token)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT Token is missing or invalid");
                return;
            }

                Authentication authentication = jwtProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request, response);
        } catch (RuntimeException e) {
            // 예외 처리: 로그를 남기거나 적절한 응답을 설정
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            // 또는 LOGGER.error("JWT Token Filter error", e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
