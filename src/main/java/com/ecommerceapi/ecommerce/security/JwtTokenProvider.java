package com.ecommerceapi.ecommerce.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class JwtTokenProvider {

    private String secretKeyAccess;
    private String secretKeyRefresh;
    private long validityInMillisecondsAccess;
    private long validityInMillisecondsRefresh;

    public JwtTokenProvider(
            @Value("${JWT_TOKEN_SECRET_KEY_ACCESS}") String secretKeyAccess,
            @Value("${JWT_TOKEN_SECRET_KEY_REFRESH}") String secretKeyRefresh,
            @Value("${JWT_TOKEN_EXPIRE_LENGTH_ACCESS}") long validityInMillisecondsAccess,
            @Value("${JWT_TOKEN_EXPIRE_LENGTH_REFRESH}") long validityInMillisecondsRefresh) {
        this.secretKeyAccess = secretKeyAccess;
        this.secretKeyRefresh = secretKeyRefresh;
        this.validityInMillisecondsAccess = validityInMillisecondsAccess;
        this.validityInMillisecondsRefresh = validityInMillisecondsRefresh;
    }

    public String createAccessToken(String userId) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMillisecondsAccess);

        return Jwts.builder()
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKeyAccess)
                .compact();
    }

    public String createRefreshToken(String userId) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMillisecondsRefresh);

        return Jwts.builder()
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKeyRefresh)
                .compact();
    }

    public Boolean checkExpAccessToken(String jwt) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKeyAccess).parseClaimsJws(jwt);
            Date exp = claims.getBody().getExpiration();
            Date now = new Date();

            if(exp.after(now)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean checkExpRefreshToken(String jwt) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKeyRefresh).parseClaimsJws(jwt);
            Date exp = claims.getBody().getExpiration();
            Date now = new Date();

            if(exp.after(now)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

//    public Boolean validationAccessToken(String jwt) {
//        if(jwt != null) {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKeyAccess).parseClaimsJws(jwt);
//            String userId = claims.getBody().get("userId") + "";
//
//            HashMap<String, Object> user_map = new HashMap<String, Object>();
//            user_map.put("userId", userId);
//            user_map.put("platformType", platformType);
//            UserVO user = userService.selectOne(user_map);
//            String accessToken = user.getAccessToken();
//
//            if(accessToken.equals(jwt)) {
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }

//    public Boolean validationRefreshToken(String jwt) {
//        if(jwt != null) {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKeyRefresh).parseClaimsJws(jwt);
//            String userId = claims.getBody().get("userId") + "";
//            String platformType = claims.getBody().get("platformType") + "";
//            HashMap<String, Object> user_map = new HashMap<String, Object>();
//            user_map.put("userId", userId);
//            user_map.put("platformType", platformType);
//            UserVO user = userService.selectOne(user_map);
//            String refreshToken = user.getRefreshToken();
//
//            if(refreshToken.equals(jwt)) {
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }

    public String getUserIdFromAccessToken(String jwt) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKeyAccess).parseClaimsJws(jwt);
            return claims.getBody().get("userId") + "";
        } catch (Exception e) {
            return null;
        }
    }

    public String getUserIdFromRefreshToken(String jwt) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKeyRefresh).parseClaimsJws(jwt);
            return claims.getBody().get("userId") + "";
        } catch (Exception e) {
            return null;
        }
    }

    public String getPlatformTypeFromAccessToken(String jwt) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKeyAccess).parseClaimsJws(jwt);
            return claims.getBody().get("platformType") + "";
        } catch (Exception e) {
            return null;
        }
    }

    public String getPlatformTypeFromRefreshToken(String jwt) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKeyRefresh).parseClaimsJws(jwt);
            return claims.getBody().get("platformType") + "";
        } catch (Exception e) {
            return null;
        }
    }
}
