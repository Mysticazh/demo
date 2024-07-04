package com.example.demo.Controller;

import com.example.demo.Service.LoginService;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.Result;

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
    public String index(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User(username, password, "");
        if (loginService.loginService(user) != null) {
            return "SUCCESS";
        } else {
            return "PASSWORD_ERR";
        }

    }
    @ResponseBody
    @RequestMapping("register")
    public String register(@RequestParam("username") String username,@RequestParam("password") String password,
                           @RequestParam("name") String name,@RequestParam("confirmPassword") String confirmPassword){
        User user = new User(username, password, name);

            return loginService.registService(user);

    }
    @ResponseBody
    @RequestMapping("/forgetpwd")
    public User forgetpwd(@RequestParam("username") String username, @RequestParam("name") String name){
        return loginService.forgetpwdService(username,name);

    }
    @ResponseBody
    @RequestMapping("/updatepwd")
    public int updatepwd(User user){

        return loginService.updateService(user);

    }

}

