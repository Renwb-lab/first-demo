package com.first.demo.service;

import com.first.demo.mapper.UserMapper;
import com.first.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenbin.ren
 */
@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User createUser(User user) {
        boolean result = userMapper.save(user);
        if (result) {
            return user;
        } else {
            return null;
        }
    }

    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    public List<User> searchUsers(User searchCriteria) {
        // 调用自定义的查询方法
        return userMapper.selectByNameLikeOrId(searchCriteria);
    }

    public List<User> selectFriendsById(Long id) {
        return userMapper.selectFriendsById(id);
    }

    public int selectFriendCountById(Long id) {
        return userMapper.selectFriendCountById(id);
    }
}
