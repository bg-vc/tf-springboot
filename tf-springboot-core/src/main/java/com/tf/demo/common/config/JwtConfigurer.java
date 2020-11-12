package com.tf.demo.common.config;

import com.tf.demo.common.constant.Const;
import com.tf.demo.common.redis.RedisService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 10:19
 * Description:
 */
@Component
@Data
@Slf4j
public class JwtConfigurer {
    @Resource
    private RedisService redisService;

    public JwtConfigurer() {
    }

    /**
     * 根据身份ID标识, 生成Token
     *
     * @param identityId
     * @return
     */
    public String generateToken(String identityId) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + Const.JWT_EXPIRE * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(identityId)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, Const.JWT_SECRET)
                .compact();
    }

    /**
     * 获取Token中注册信息
     *
     * @param token
     * @return
     */
    public Claims getTokenClaim(String token) {
        try {
            return Jwts.parser().setSigningKey(Const.JWT_SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error("getTokenClaim error:{}", e.getMessage());
            return null;
        }
    }

    /**
     * Token是否过期验证
     *
     * @param expirationTime
     * @return
     */
    public boolean isTokenExpired(Date expirationTime) {
        return expirationTime.before(new Date());
    }

    /**
     * @param token
     * @return
     */
    public boolean isValidFromRedis(String token) {
        String key = Const.JWT_TOKEN_PREFIX_KEY + token;
        return redisService.hashKey(key);
    }
}
