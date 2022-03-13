package com.example.multiple.mapper.d2;

import com.example.multiple.entity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper {
    List<Group> getGroup();
}
