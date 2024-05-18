package com.first.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.first.demo.model.User;

import java.util.List;

/**
 * @author wenbin.ren
 */
public interface UserMapper extends BaseMapper<User> {
    boolean save(User user);
    List<User> selectByNameLikeOrId(User user);

    List<User> selectFriendsById(Long id);

    int selectFriendCountById(Long id);
}
