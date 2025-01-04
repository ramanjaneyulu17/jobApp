package com.example.JobApp.service;

import com.example.JobApp.model.UserPrincipal;
import com.example.JobApp.model.Users;
import com.example.JobApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUserName(username);
        if(user==null){
            System.out.println("Not found 404");
            throw new UsernameNotFoundException("Not fount 404");
        }
        return new UserPrincipal(user);
    }
}

