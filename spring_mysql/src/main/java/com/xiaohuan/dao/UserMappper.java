package com.xiaohuan.dao;

import com.xiaohuan.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMappper {
    User getById(@Param("id") String id);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int UserId);
}
