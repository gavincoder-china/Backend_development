package com.gavin.token.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Slf4j
@Component
@ConfigurationProperties(prefix = "jwt.config")
public class JwtUtil {

    /**
     * 加密秘钥
     */
    private String secret;
    /**
     * 有效时间 单位是 秒
     */
    private long expire;


    /**
     * @return
     * @throws
     * @description 生成token
     * @author Gavin
     * @date 2019-10-04 10:23
     * @since
     */

    public String createJwt(Long userId, String userName) {

        //当前时间
        Date nowDate = new Date();

        //当前时间+过期时长=>过期的时间点  =System.currentTimeMillis()+ expire * 1000
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                   .setHeaderParam("typ", "JWT")
                   .setId(String.valueOf(userId))
                   .setSubject(userName)
                   .setIssuedAt(nowDate)
                   .setExpiration(expireDate)
                   .signWith(SignatureAlgorithm.HS512, getSecret())
                   .compact();
    }


    /**
     * @return io.jsonwebtoken.Claims
     * @throws
     * @description 解析token
     * @author Gavin
     * @date 2019-10-04 10:53
     * @since
     */

    public Claims parseJWT(String token) {
        try {
            return Jwts.parser()
                       .setSigningKey(secret)
                       .parseClaimsJws(token)
                       .getBody();
        }
        catch (Exception e) {
            log.debug("validate is token error ", e);
            return null;
        }
    }


}
