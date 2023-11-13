package com.example.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "jwt") // 读取yml的jwt配置
public class JwtUtil {

    private long expire;
    private String secret;
    private String header;

    /**
     * 生成Token
     * @param username
     * @return
     */
    public String generateToken(String username){
        Date noweDate = new Date();
        Date expireDate = new Date(noweDate.getTime()*1000 + expire);

        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(username)
                .setIssuedAt(noweDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.ES512,secret)
                .compact();
    }

    /**
     * 解析Token
     * @param header
     * @return
     */
    public Claims getClaimsByToken(String header){
        try{
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(header)
                    .getBody();
        }catch(Exception e){
            return null;
        }
    }

    /**
     * 判断Token是否已经过期
     * @param claims
     * @return
     */
    public boolean isTokenExpired(Claims claims){
        return claims.getExpiration().before(new Date());
    }
}
