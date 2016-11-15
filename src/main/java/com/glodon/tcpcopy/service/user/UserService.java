package com.glodon.tcpcopy.service.user;

import com.glodon.tcpcopy.bo.user.User;
import org.springframework.stereotype.Service;

/**
 * Created by zhangxin on 2016/11/9.
 */
public interface UserService {

    User getUser();

    User getUserByLoginName(String userId);

    void addUser(User user);
}
