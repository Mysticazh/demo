package com.example.demo.Service;

import com.example.demo.pojo.User;

public interface LoginService {
    public User loginService(User user);
    public String registService(User user);
    public User forgetpwdService(String username,String name);
    public int updateService(User user);
}
