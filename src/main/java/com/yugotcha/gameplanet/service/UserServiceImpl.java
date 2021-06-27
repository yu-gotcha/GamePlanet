package com.yugotcha.gameplanet.service;

import com.yugotcha.gameplanet.domain.User;
import com.yugotcha.gameplanet.dto.UserDTO;
import com.yugotcha.gameplanet.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(@Lazy PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("The username is not found."));
    }

    @Override
    public boolean login(UserDTO user) throws UsernameNotFoundException, BadCredentialsException {
        User member = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("The username is not found."));
        if (!passwordEncoder.matches(user.getPassword(), member.getPassword())) {
            throw new BadCredentialsException("The user is not found.");
        }

        user.setRoles(member.getRoles());

        return true;
    }

    @Override
    public Long join(UserDTO user) throws IllegalArgumentException {
        System.out.println("Service---join----"+user.getUsername()+":"+user.getPassword());
        return userRepository.save(User.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .nickname(user.getNickname())
                .roles(Collections.singletonList("ROLE_USER"))
                .build()).getIdx();
    }
}
