package com.inory.foodtrace.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.interfaces.Claim;
import com.inory.foodtrace.entity.User;
import com.inory.foodtrace.service.UserService;
import com.inory.foodtrace.utils.JWTUtil;
import com.inory.foodtrace.utils.Result;
import com.inory.foodtrace.utils.SmsUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * The type Login controller.
 *
 * @author inory
 * @create 2021 -07-21 18:01
 */

@RestController
@RequestMapping("/api/account")
@Api(tags = {"Account"})
public class AccountController {

    @Resource
    UserService userService;

    @PostMapping("login")
    @ApiOperation(value = "Login with username and password")
    public Result login(@ApiParam(value = "用户实体", required = true) @RequestBody User user) throws Exception {
        User user2 = userService.selectUserByNameAndPwd(user.getName(), user.getPassword());
        if (ObjectUtil.isNotNull(user2)) {
            Long id = user2.getId();
            return Result.ok().data("token", JWTUtil.createToken(id));
        } else {
            return Result.error().data("errMsg", "用户不存在");
        }
    }

    @PostMapping("userinfo")
    @ApiOperation(value = "Get userinfo with token")
    public Result getInfo(@ApiParam(value = "token", required = true) @RequestParam String token) {
        try {
            Map<String, Claim> map = JWTUtil.verifyToken(token);
            Long id = JWTUtil.getAppUID(token);
            User user = userService.getUserInfo(id);
            String role = user.getRole();

            Map<Object, Object> newMap = MapUtil.of(new String[][]{
                    {"aud", StringUtils.replace(map.get("aud").asString(), "/", "")},
                    {"user_id", StringUtils.replace(map.get("user_id").asString(), "/", "")},
                    {"iss", StringUtils.replace(map.get("iss").asString(), "/", "")},
                    {"exp", map.get("exp").toString()},
                    {"iat", map.get("iat").toString()},
            });
            return Result.ok().data("map", newMap)
                    .data("roles", ArrayUtils.toArray(role))
                    .data("avatar", user.getAvatar())
                    .data("name", user.getName());

        } catch (Exception e) {
            return Result.error().data("errMsg", "token校验失败");
        }
    }

    @PostMapping("register")
    public Result register(@ApiParam(value = "用户实体", required = true) @RequestBody User user) {
        try {
            userService.insertUser(user);
            return Result.ok().data("msg", "注册成功");
        } catch (Exception e) {
            return Result.error();
        }
    }

    @PostMapping("sms")
    public Result getSms(@RequestParam String phone) {
        String msg = SmsUtil.sendSms(phone, "2593", "10");
        return Result.ok().data("msg", msg);
    }

}
