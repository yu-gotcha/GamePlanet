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

@Controller
@AllArgsConstructor
@RequestMapping(value = "")
public class GameController {

    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping(value = "cookingGame")
    public String cookingGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model){
        String username = jwtTokenProvider.getUserUsername(authCookie);
        model.addAttribute("username", username);

        return "cookingGame";
    }

    @GetMapping(value = "bullsAndCowsGame")
    public String bullsAndCowsGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        String username = jwtTokenProvider.getUserUsername(authCookie);
        model.addAttribute("username", username);

        return "bullsAndCowsGame";
    }

    @GetMapping(value = "rhythmGame")
    public String rhythmGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        String username = jwtTokenProvider.getUserUsername(authCookie);
        model.addAttribute("username", username);

        return "rhythmGame";
    }

    @GetMapping(value = "martGame")
    public String martGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        String username = jwtTokenProvider.getUserUsername(authCookie);
        model.addAttribute("username", username);

        return "martGame";
    }

    @GetMapping(value = "matchingGame")
    public String matchingGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        String username = jwtTokenProvider.getUserUsername(authCookie);
        model.addAttribute("username", username);

        return "matchingGame";
    }

    @GetMapping(value = "rockPaperScissorsGame")
    public String rockPaperScissorsGame(@CookieValue(value = "token", required = false, defaultValue = "0")String authCookie, Model model) {
        String username = jwtTokenProvider.getUserUsername(authCookie);
        model.addAttribute("username", username);

        return "rockPaperScissorsGame";
    }

}