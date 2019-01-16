package org.xiaoxuetu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiaoxuetu.common.Constant;
import org.xiaoxuetu.model.User;

@RestController
@Api(description = "用户管理")
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    @ApiOperation(value = "使用Restful的方式根据id获取记录", response = User.class)
    @ApiImplicitParams({
        // 注意这里必须设置example="0"，否则打开首页的时候swagger会发个空字符串回来，控制台报数字转换异常
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "主键", example="0", required = true)
    })
    public User restfulGet(@PathVariable long id) {
        return User.builder()
            .id(id)
            .username(Constant.CONTACT_NAME)
            .password(Constant.CONTACT_URL)
            .build();
    }

    @GetMapping
    @ApiOperation(value = "使用param的方式根据id获取记录", response = User.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "long", name = "id", value = "主键", example="0", required = true)
    })
    public User paramGet(long id) {
        return User.builder()
            .id(id)
            .username(Constant.CONTACT_NAME)
            .password(Constant.CONTACT_URL)
            .build();
    }
}
