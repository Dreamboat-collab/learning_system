package com.example.learning_system;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Token {
    @Test
    public void testGen(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"jeddymadasdasdawdad")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();
        System.out.println(jwt);
    }
}
