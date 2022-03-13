package com.xiaohuan.service;

import com.xiaohuan.bean.User;

public interface UserService {

    User getUser(String id);

    String addUser(User user);
}
