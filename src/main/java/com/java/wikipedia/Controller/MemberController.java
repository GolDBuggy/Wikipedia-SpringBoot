package com.java.wikipedia.Controller;

import com.java.wikipedia.Dto.RegisterDto;
import com.java.wikipedia.LoginRequest.Login;
import com.java.wikipedia.Model.Member;
import com.java.wikipedia.Service.JwtService;
import com.java.wikipedia.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public void saveMember(@RequestBody RegisterDto registerDto){
        memberService.saveMember(registerDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()));
            return ResponseEntity.ok(jwtService.generateToken(login.getUsername()));
    }



}
