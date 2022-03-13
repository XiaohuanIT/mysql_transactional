package com.example.multiple.mapper.d1;

import com.example.multiple.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUser();
}
