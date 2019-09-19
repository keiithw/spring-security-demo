package com.keith.security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    @RequestMapping("/hi")
    public String toHi(){
        return "hi";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
}
