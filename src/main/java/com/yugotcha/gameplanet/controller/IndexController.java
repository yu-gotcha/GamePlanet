package com.yugotcha.gameplanet.controller;

import com.yugotcha.gameplanet.config.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "")
public class IndexController {

    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping
    public String index(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        if(!authCookie.equals("0")){
            String username = jwtTokenProvider.getUserUsername(authCookie);
            model.addAttribute("username", username);
        }

        return "index";
    }
}
