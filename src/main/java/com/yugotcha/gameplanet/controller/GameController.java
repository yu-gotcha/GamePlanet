package com.yugotcha.gameplanet.controller;

import com.yugotcha.gameplanet.config.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping(value = "")
public class GameController {

    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping(value = "cookingGame")
    public String cookingGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model){
        if(!authCookie.equals("0")) setUser(authCookie, model);

        return "cookingGame";
    }

    @GetMapping(value = "bullsAndCowsGame")
    public String bullsAndCowsGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        if(!authCookie.equals("0")) setUser(authCookie, model);

        return "bullsAndCowsGame";
    }

    @GetMapping(value = "rhythmGame")
    public String rhythmGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        if(!authCookie.equals("0")) setUser(authCookie, model);

        return "rhythmGame";
    }

    @GetMapping(value = "martGame")
    public String martGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        if(!authCookie.equals("0")) setUser(authCookie, model);

        return "martGame";
    }

    @GetMapping(value = "matchingGame")
    public String matchingGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        if(!authCookie.equals("0")) setUser(authCookie, model);

        return "matchingGame";
    }

    @GetMapping(value = "rockPaperScissorsGame")
    public String rockPaperScissorsGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        if(!authCookie.equals("0")) setUser(authCookie, model);

        return "rockPaperScissorsGame";
    }

    public void setUser(String token, Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("username", jwtTokenProvider.getUserUsername(token));

        model.addAttribute("userdata", map);
    }

}