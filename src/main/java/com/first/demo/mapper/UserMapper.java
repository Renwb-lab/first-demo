package com.first.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.first.demo.model.User;

public interface UserMapper extends BaseMapper<User> {
    boolean save(User user);
}
