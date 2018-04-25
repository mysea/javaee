package com.spring.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;


//@RestController
@Controller
public class IndexController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "I'm come back";
    }

    @RequestMapping("/hello")
    public String hello(Model model) throws Exception {
        model.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
        if (true){
            throw new Exception("");
        }
        return "hello";
    }
}
