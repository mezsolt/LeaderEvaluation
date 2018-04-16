package com.LeaderEvaluation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mezsolt on 2018.04.08..
 */

@Controller
public class ViewController {

    @RequestMapping(value = {"/workers","/login"},method = RequestMethod.GET)
    public String index() {
        return "forward:/index.html";
    }

}