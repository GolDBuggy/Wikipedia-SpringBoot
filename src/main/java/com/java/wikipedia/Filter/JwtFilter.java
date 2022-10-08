package com.java.wikipedia.Filter;

import com.java.wikipedia.Service.JwtService;
import com.java.wikipedia.Service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final MemberDetailService detailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header=request.getHeader("Authorization");
        String token=null;
        String username=null;

        if (header!=null&&header.startsWith("Bearer ")){
            token=header.substring(7);
            username=jwtService.getUsernameByToken(token);
        }

        if (username!=null&& SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=detailService.loadUserByUsername(username);
            if (jwtService.validateToken(token)){
                UsernamePasswordAuthenticationToken upToken=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(upToken);
            }

        }

        filterChain.doFilter(request,response);
    }
}
