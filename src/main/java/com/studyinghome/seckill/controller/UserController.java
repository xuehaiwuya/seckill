package com.studyinghome.seckill.controller;

import com.studyinghome.seckill.domain.MiaoshaUser;
import com.studyinghome.seckill.redis.RedisService;
import com.studyinghome.seckill.result.Result;
import com.studyinghome.seckill.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    MiaoshaUserService userService;
    @Autowired
    RedisService redisService;

    @RequestMapping("/info")
    public Result<MiaoshaUser> info(Model model, MiaoshaUser user) {
        return Result.success(user);
    }

}
