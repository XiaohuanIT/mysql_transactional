package com.xiaohuan.service;

import com.xiaohuan.bean.User;
import com.xiaohuan.bean.UserLog;
import com.xiaohuan.dao.UserLogMappper;
import com.xiaohuan.dao.UserMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMappper userDao;

    @Autowired
    private UserLogMappper userLogMappper;

    @Override
    public User getUser(String id) {
        return userDao.getById(id);
    }

    @Override
    public String addUser(User user) {

        operateDB(user);
        return user.getId();
    }

    @Transactional
    public void operateDB(User user){
        UserLog userLog = new UserLog();
        userLog.setUserId(user.getId());
        userLogMappper.addUserLog(userLog);
        userDao.addUser(user);
    }

}
