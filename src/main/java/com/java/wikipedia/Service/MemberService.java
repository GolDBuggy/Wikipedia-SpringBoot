package com.java.wikipedia.Service;

import com.java.wikipedia.Model.Member;
import com.java.wikipedia.Repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo memberRepo;
    private final BCryptPasswordEncoder encoder;

    private static String DEFAULT_ROLE="ROLE_USER";



    public void saveMember(Member member){
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRoles(DEFAULT_ROLE);
        memberRepo.save(member);
    }
}
