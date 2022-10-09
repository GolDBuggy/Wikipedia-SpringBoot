package com.java.wikipedia.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private String key="Wikipedia-15-January";

    public String generateToken(String username){
        return Jwts.builder().setSubject(username).
                setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256,key).setIssuer("author").
                setExpiration(new Date(System.currentTimeMillis()+20*60*1000)).compact();
    }


    public boolean validateToken(String token){
        if (getUsernameByToken(token)!=null&&checkExpiration(token))
            return true;

     return false;
    }


    private boolean checkExpiration(String token){
        Claims claims=getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }


    public String getUsernameByToken(String token){
        Claims claims=getClaims(token);
        return claims.getSubject();
    }
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }
}
