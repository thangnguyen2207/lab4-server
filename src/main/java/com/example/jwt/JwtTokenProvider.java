package com.example.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {
	// Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private final String JWT_SECRET = "lab4";
    
    //Thời gian có hiệu lực của chuỗi jwt
    private final long JWT_EXPIRATION = 604800000L;
    
	@Autowired
	private UserService userService;
    
    public String generateToken(User user) {
    	Date now = new Date();
    	Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
    	
    	User u = userService.findUserByUsername(user.getUsername());
    	return Jwts.builder()
    				.setSubject(Integer.toString(u.getId()))
    				.setIssuedAt(now)
    				.setExpiration(expiryDate)
    				.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
    				.compact();
    			
    }
    
    public Integer getUserIdFromJWT(String token) {
    	Claims claims = Jwts.parser()
    			.setSigningKey(JWT_SECRET)
    			.parseClaimsJws(token)
    			.getBody();
    	
    	return Integer.parseInt(claims.getSubject());
    }
    
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
