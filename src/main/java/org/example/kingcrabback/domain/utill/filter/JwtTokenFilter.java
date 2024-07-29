package org.example.kingcrabback.domain.utill.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenResolver jwtTokenResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String parseToken = jwtTokenResolver.resolveToken(request);
        if(parseToken != null) {
            Authentication authentication = jwtTokenResolver.authentication(parseToken);
         }
        filterChain.doFilter(request, response);
    }
}
