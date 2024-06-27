package com.example.demo.Controller;

import com.example.demo.Service.LoginService;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/")
    public String login() {
        return "login.html";
    }
    @ResponseBody
    @RequestMapping("/index")
    public String index(@RequestBody User user) {
        if(loginService.loginService(user)!=null){
            return "SUCCESS";
        }
        else {
            return "PASSWORD_ERR";
        }
        /*if (!user.getUsername().equals("azh") ) {
            return "USER_NOT_EXIST";
        }
        if(user.getPassword().equals("000")){
            return "ACCOUNT_OLD";
        }
        if(!user.getPassword().equals("123")){
            return "PASSWORD_ERR";
        }
        return "SUCCESS";*/
    }
}

