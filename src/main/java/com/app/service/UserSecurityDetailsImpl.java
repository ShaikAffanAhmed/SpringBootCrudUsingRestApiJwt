package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repository.UserRepository;

@Service
public class UserSecurityDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=this.repository.findByMailId(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("user doesnot exists");
        }
        return user;
    }




}
