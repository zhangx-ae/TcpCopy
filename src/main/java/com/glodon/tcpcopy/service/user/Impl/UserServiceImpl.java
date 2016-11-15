package com.glodon.tcpcopy.service.user.Impl;

import com.glodon.tcpcopy.bo.user.User;
import com.glodon.tcpcopy.dao.UserDao;
import com.glodon.tcpcopy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangxin on 2016/11/10.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDAO;

    public User getUser() {
        return null;
    }

    public User getUserByLoginName(String userId) {
        return userDAO.selectByLoginName(userId);
    }

    public void addUser(User user) {
        userDAO.insertSelective(user);
    }
}
