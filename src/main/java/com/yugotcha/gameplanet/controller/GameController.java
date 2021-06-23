package com.yugotcha.gameplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"game1", "game2", "game3", "game4", "game5", "game6"})
public class GameController {

    @GetMapping(value = "")
    public String game (HttpServletRequest request){
        String requestUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        System.out.println(requestUrl);
        switch(requestUrl){
            case "/game1" :

                return "game1";

            case "/game2" :

                return "game2";

            case "/game3" :

                return "game3";

            case "/game4" :

                return "game4";

            case "/game5" :

                return "game5";

            case "/game6" :

                return "game6";
        }
        return "error";
    }

}