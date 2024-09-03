package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class JwtService {
	@Value("${security.jwt.secret-key}")
	private String secretKey;
	
	private long jwtExpiration=60 * 60 * 24;
	
	public long getExpirationTime() {
        return jwtExpiration;
    }
	
	public String generateToken(UserDetails userDetails
            ) {
		return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
	}
	
	  public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	  }
	  
	  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	  }
	  
	  private Claims extractAllClaims(String token) {
	        return Jwts
	                .parser()
	                .setSigningKey(getSignInKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	   }
	  
	  private boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	  }
	  
	  private Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	  }
	  
	  public boolean isTokenValid(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
	  }
	  
	  private Key getSignInKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
	        return Keys.hmacShaKeyFor(keyBytes);
	  }

}
