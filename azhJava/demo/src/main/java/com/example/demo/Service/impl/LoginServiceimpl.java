package com.example.demo.Service.impl;

import com.example.demo.Service.LoginService;
import com.example.demo.dao.LoginDao;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceimpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public User loginService(User user) {
        User nowUser=loginDao.getUserbypwd(user.getUsername(),user.getPassword());
        return nowUser;
    }
}
