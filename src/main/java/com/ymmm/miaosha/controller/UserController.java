package com.ymmm.miaosha.controller;

import com.ymmm.miaosha.domain.MiaoshaUser;
import com.ymmm.miaosha.redis.RedisService;
import com.ymmm.miaosha.result.Result;
import com.ymmm.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
    MiaoshaUserService userService;
	
	@Autowired
    RedisService redisService;
	
    @RequestMapping("/info")
    @ResponseBody
    public Result<MiaoshaUser> info(MiaoshaUser user) {
        return Result.success(user);
    }
    
}
