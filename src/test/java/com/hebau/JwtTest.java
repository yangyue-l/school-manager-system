package com.hebau;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTest {


    @Test
    public void testGenerateJwt(){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username", "admin");

        String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, "eWFuZ3l1ZQ==")
                    .addClaims(dataMap)
                    .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                    .compact();
        
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        String token = "";
        Claims claims = Jwts.parser()
                        .setSigningKey("eWFuZ3l1ZQ==")
                        .parseClaimsJws(token)
                        .getBody();
        System.out.println(claims);
    }

}
