package com.cactt4ck.lifestyleapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Component
public class TokenFilter extends OncePerRequestFilter {

    @Value("${lifestyle-app.token}")
    private String bearerToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getHeader("Authorization") == null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return;
        }

        String token = request.getHeader("Authorization").substring(7);

        String encryptedBearerToken = this.encryptToken(bearerToken);
        String encryptedToken = this.encryptToken(token);

        if (encryptedToken == null || !encryptedToken.equals(encryptedBearerToken)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private String encryptToken(String token) {
        String encryptedToken = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = digest.digest(token.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            encryptedToken = hexString.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }
        return encryptedToken;
    }

}
