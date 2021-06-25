package com.yugotcha.gameplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "")
public class GameController {

    @GetMapping(value = "cookingGame")
    public String cookingGame(){ return "cookingGame"; }

    @GetMapping(value = "bullsAndCowsGame")
    public String bullsAndCowsGame(){ return "bullsAndCowsGame"; }

    @GetMapping(value = "rhythmGame")
    public String rhythmGame(){ return "rhythmGame"; }

    @GetMapping(value = "martGame")
    public String martGame(){ return "martGame"; }

    @GetMapping(value = "matchingGame")
    public String matchingGame(){ return "matchingGame"; }

    @GetMapping(value = "rockPaperScissorsGame")
    public String rockPaperScissorsGame(){ return "rockPaperScissorsGame"; }

}