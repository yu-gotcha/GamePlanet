package com.yugotcha.gameplanet.service;

import com.yugotcha.gameplanet.dto.UserDTO;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {

    @Override
    public boolean login(UserDTO user) throws UsernameNotFoundException, BadCredentialsException {
        return false;
    }

    @Override
    public Long join(UserDTO user) throws IllegalArgumentException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
