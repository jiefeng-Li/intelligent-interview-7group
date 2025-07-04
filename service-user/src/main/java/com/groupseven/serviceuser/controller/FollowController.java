package com.groupseven.serviceuser.controller;

import com.groupseven.common.Result;
import com.groupseven.serviceuser.pojo.entity.Follow;
import com.groupseven.serviceuser.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    private FollowService followService;

    @PostMapping("/{entId}")
    public Result<Void> follow(@RequestHeader int userId, @PathVariable int entId) {
        followService.follow(userId, entId);
        return Result.success();
    }

    @DeleteMapping("/{entId}")
    public Result<Void> unfollow(@RequestHeader int userId, @PathVariable int entId) {
        followService.unfollow(userId, entId);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Follow>> getFollowList(@RequestHeader int userId) {
        return Result.success(followService.getFollowList(userId));
    }

    @GetMapping("/count")
    public Result<Integer> getFollowCount(@RequestHeader int userId) {
        return Result.success(followService.getFollowCount(userId));
    }
} 