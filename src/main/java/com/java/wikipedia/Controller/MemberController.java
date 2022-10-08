package com.java.wikipedia.Controller;

import com.java.wikipedia.LoginRequest.Login;
import com.java.wikipedia.Model.Member;
import com.java.wikipedia.Service.JwtService;
import com.java.wikipedia.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public void saveMember(@RequestBody Member member){
        memberService.saveMember(member);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){
        return ResponseEntity.ok(jwtService.generateToken(login.getUsername()));
    }


}
