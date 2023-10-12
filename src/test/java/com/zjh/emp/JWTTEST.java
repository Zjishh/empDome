package com.zjh.emp;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/****************************
 * @project empservice
 * @package com.zjh.emp
 * @className JWTTEST
 * @author Zjiah
 * @date 2023/10/11 15:06
 * @Description:   *
 ****************************/
//@SpringBootTest
public class JWTTEST {
    /**
     * jwt令牌生成
     */
    @Test
    public void testJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("user", "张家豪");
        String itheima = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheimamamamama")  //签名算法
                .setClaims(claims)//自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置过期时间
                .compact();//生成
        System.out.println(itheima);


    }

    @Test
    public void getJWT(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheimamamamama")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjk3MDEyMjA3LCJ1c2VyIjoi5byg5a626LGqIn0.QyGCIi5JjiBc_gemZVjSC_9qKg6R17O00EqVGIiMFAs")
                .getBody();
        System.out.println(claims);
    }
}
