package com.future.risk.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

    @RequestMapping(value="login")
    public String login(){
        return "login";
    }
    
    @RequestMapping(value="instrument")
    public String instrument(){
        return "instrument";
    }
    
    @RequestMapping(value="market")
    public String market(){
        return "market";
    }
    
    @RequestMapping(value="quota")
    public String quota(){
        return "quota";
    }
    
}
