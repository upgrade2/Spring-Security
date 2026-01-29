package com.coding.shuttel.learn.security;

import com.coding.shuttel.learn.repository.entity.User;
import com.coding.shuttel.learn.service.JwtService;
import com.coding.shuttel.learn.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    final  String requestTokenHeader = request.getHeader("Authorization");
    if(requestTokenHeader==null|| !requestTokenHeader.startsWith("Bearer")){
        filterChain.doFilter(request,response);
        return;
    }

    String token = requestTokenHeader.split("Bearer")[1];
    Long userId=jwtService.getUserIdFromToken(token);

        if(userId!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            //generate token
            User user = userService.getUserById(userId);

        }
        filterChain.doFilter(request,response);
    }
}
