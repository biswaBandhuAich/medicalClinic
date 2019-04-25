package com.example.medical.Bean;

import com.example.medical.services.UserDml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BaseAuthenticationProvider implements AuthenticationProvider {
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    UserDml userDml;
    @Autowired
    public void setUserDml(UserDml userDml) {
        this.userDml = userDml;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        Object password = authentication.getCredentials();
        if(password!=null){
        System.out.println("Ello ekhane"+password);}
        if (userDml.find(username, password)) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            System.out.println("Login Unauthenticated");
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
