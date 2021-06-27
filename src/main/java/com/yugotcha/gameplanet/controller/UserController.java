package com.yugotcha.gameplanet.controller;

import com.yugotcha.gameplanet.config.JwtTokenProvider;
import com.yugotcha.gameplanet.dto.UserDTO;
import com.yugotcha.gameplanet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping(value = "/login")
    public String userLogin(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie) {
        System.out.println(authCookie);
        if(!authCookie.equals("0")) return "redirect:/";
        return "/users/login";
    }

    @PostMapping(value = "/login")
    public String login(String username, String password, HttpServletResponse response) {
        System.out.println("로그인 시도");
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(password);

        if(user.getUsername().equals("") || user.getPassword().equals("")) return "redirect:login";

        try {
            if(userService.login(user)) {
                System.out.println("일치 있음");
                String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles(), user.getNickname());
                Cookie authCookie =  new Cookie("token", token);
                authCookie.setPath("/");

                response.addCookie(authCookie);
                return "redirect:/";
            }
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            return "redirect:login";
        }

        return "redirect:login";
    }

    @GetMapping(value = "/join")
    public String userJoin(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie) {
        if(!authCookie.equals("0")) return "redirect:/";
        return "/users/join";
    }

    @PostMapping(value = "/join")
    public String join(String username, String password, String nickname, String email) {
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setEmail(email);

        System.out.println(user.getUsername());

        try {
            return userService.join(user) > 0 ? "redirect:/users/login" : "redirect:join";
        } catch (Exception e) {
            return "redirect:join";
        }
    }
}
