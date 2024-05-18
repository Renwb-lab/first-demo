package com.first.demo.controller;

import com.first.demo.service.FriendService;
import com.first.demo.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wenbin.ren
 */
@RestController
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    // 添加朋友关系的API
    @PostMapping("/add")
    public boolean addFriend(@RequestParam Long userId, @RequestParam Long friendId) {
        return friendService.addFriend(userId, friendId);
    }

    // 其他API...
}