package com.java.wikipedia.Service;

import com.java.wikipedia.Dto.RegisterDto;
import com.java.wikipedia.LoginRequest.Login;
import com.java.wikipedia.Model.Member;
import com.java.wikipedia.Repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo memberRepo;
    private final ModelMapper mapper;
    private final BCryptPasswordEncoder encoder;

    private static String DEFAULT_ROLE="ROLE_USER";



    public void saveMember(RegisterDto registerDto){
        checkPass(registerDto);
        memberRepo.save(memberConfg(registerDto));
    }

    private Member memberConfg(RegisterDto registerDto){
        Member member=mapper.map(registerDto,Member.class);
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRoles(DEFAULT_ROLE);
        return member;
    }

    private void checkPass(RegisterDto registerDto){
        if(!registerDto.getPassword().equals(registerDto.getRe_password()))
            throw new RuntimeException("Passwords must be equals!");
    }


    public Member getByUsername(String username) {
        return memberRepo.findByUsername(username).get();
    }
}
