package com.yugotcha.gameplanet.controller;

import com.yugotcha.gameplanet.config.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "")
public class IndexController {

    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping
    public String index(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        if(!authCookie.equals("0")){
            Map<String, Object> map = new HashMap<>();
            map.put("username", jwtTokenProvider.getUserUsername(authCookie));

            model.addAttribute("userdata", map);
        }

        return "index";
    }
}
