package com.student.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

    // token 过期时间，单位毫秒
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    // 私钥
    private static final String SECRET = "your_secret_key";

    /**
     * 生成 token
     *
     * @param userId 用户 ID
     * @return token 字符串
     */
    public static String generateToken(Long userId) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        String token = JWT.create()
                .withHeader(header)
                .withClaim("userId", userId)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    /**
     * 解析 token 中的用户 ID
     *
     * @param token token 字符串
     * @return 用户 ID
     */
    public static Long getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asLong();
        } catch (JWTDecodeException e) {
            // 解码失败，token 不合法
            return null;
        }
    }
}
