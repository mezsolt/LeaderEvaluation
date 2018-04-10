package com.LeaderEvaluation.controller;

/**
 * Created by mezsolt on 2018.04.08..
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

    @RequestMapping(value = {"/workers","/login"},method = RequestMethod.GET)
    public String index() {
        return "forward:/index.html";
    }

}