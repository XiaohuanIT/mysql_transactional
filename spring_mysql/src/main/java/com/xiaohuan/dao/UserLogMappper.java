package com.xiaohuan.dao;

import com.xiaohuan.bean.UserLog;
import org.apache.ibatis.annotations.Param;

public interface UserLogMappper {

    void addUserLog(UserLog userLog);

    void deleteUserLog(@Param("userId") String userId);
}
