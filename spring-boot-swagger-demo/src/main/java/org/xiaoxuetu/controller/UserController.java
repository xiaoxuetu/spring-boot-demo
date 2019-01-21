package org.xiaoxuetu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiaoxuetu.common.Constant;
import org.xiaoxuetu.dto.ResponseResult;
import org.xiaoxuetu.model.User;

@RestController
@Api(description = "用户管理")
@RequestMapping("/user")
public class UserController {

    @GetMapping("/rest/{id}")
    // 此处没有指定response，swagger会自动识别并且声称对应的说明
    // 但是返回值里面的泛型中一定要添加具体的类
    @ApiOperation(value = "使用Restful的方式根据id获取记录", notes = "this is note")
    @ApiImplicitParams({
        // 注意这里必须设置example="0"，否则打开首页的时候swagger会发个空字符串回来，控制台报数字转换异常
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "主键", example="0", required = true)
    })
    @ApiResponses(value = {
        @ApiResponse(code = 403, message = "用户没有权限"),
        @ApiResponse(code = 400, message = "参数无效")
    })
    public ResponseResult<User> restfulGet(@PathVariable long id) {
        ResponseResult<User> responseResult = ResponseResult.success();
        responseResult.setData(User.builder()
            .id(id)
            .username(Constant.CONTACT_NAME)
            .password(Constant.CONTACT_URL)
            .build());
        return responseResult;
    }

    @GetMapping("/param")
    @ApiOperation(value = "使用param的方式根据id获取记录", response = User.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "long", name = "id", value = "主键", example="0", required = true)
    })
    public ResponseResult<User>  paramGet(long id) {
        ResponseResult<User> responseResult = ResponseResult.success();
        responseResult.setData(User.builder()
            .id(id)
            .username(Constant.CONTACT_NAME)
            .password(Constant.CONTACT_URL)
            .build());
        return responseResult;
    }
}
