package com.gavin.token;

import io.jsonwebtoken.*;

import java.util.Date;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-26 23:29
 * @description: JWT验证测试
 ************************************************************/
public class Creat {

    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                                    .setId("666")
                                    .setSubject("gavin")
                                    .setIssuedAt(new Date())
                                    .signWith(SignatureAlgorithm.HS256, "coder");
        System.out.println(jwtBuilder.compact());
        System.out.println("--------");

        Claims claims = Jwts.parser().setSigningKey("coder").parseClaimsJws(jwtBuilder.compact())
                           .getBody();
        System.out.println(claims);
    }
}
