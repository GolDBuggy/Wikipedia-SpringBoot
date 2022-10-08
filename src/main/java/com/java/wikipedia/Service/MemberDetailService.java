package com.java.wikipedia.Service;

import com.java.wikipedia.Model.Member;
import com.java.wikipedia.Repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService {

    private final MemberRepo memberRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member=memberRepo.findByUsername(username).get();
        return new User(member.getUsername(),member.getPassword(), Arrays.asList(member.getRoles().split(",")).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
