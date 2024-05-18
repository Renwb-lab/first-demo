package com.first.demo.service;

import com.first.demo.mapper.FriendMapper;
import com.first.demo.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
    private final FriendMapper friendMapper;

    @Autowired
    public FriendService(FriendMapper friendMapper) {
        this.friendMapper = friendMapper;
    }

    // 示例：添加朋友关系
    public boolean addFriend(Long userId, Long friendId) {
        Friend friend = new Friend();
        friend.setUserId(userId);
        friend.setFriendId(friendId);
        return friendMapper.insert(friend) > 0;
    }

}