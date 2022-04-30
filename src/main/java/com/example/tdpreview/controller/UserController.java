package com.example.tdpreview.controller;

import com.example.tdpreview.common.RestResponse;
import com.example.tdpreview.pojo.Msg;
import com.example.tdpreview.service.UserService;
import com.example.tdpreview.vo.MsgVO;
import com.example.tdpreview.vo.UserInfoVO;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @ApiOperation("登录")
    @PostMapping(value = "/login")
    public RestResponse<UserInfoVO> login(@RequestBody UserInfoVO userInfoVO) {
        UserInfoVO userVO =userService.login(userInfoVO);
        return RestResponse.success(userVO);
    }

    @ApiOperation("注册")
    @PostMapping(value = "/register")
    public RestResponse<UserInfoVO> register(@RequestBody UserInfoVO userInfoVO) {
        if (!StringUtils.hasText(userInfoVO.getName())
                ||!StringUtils.hasText(userInfoVO.getPwd())
                ||!StringUtils.hasText(userInfoVO.getNo())){
            return RestResponse.error(400,"请输入完整信息");
        }
        UserInfoVO userVO =userService.register(userInfoVO);
        return RestResponse.success(userVO);
    }

    @ApiOperation("发消息")
    @PostMapping(value = "/send")
    public RestResponse send(@RequestBody MsgVO msgVO) {
        if (!StringUtils.hasText(msgVO.getName())
                ||!StringUtils.hasText(msgVO.getDate())
                ||!StringUtils.hasText(msgVO.getText())){
            return RestResponse.error(400,"请输入完整信息");
        }
        userService.sendMsg(msgVO);
        return RestResponse.success();
    }

    @ApiOperation("收消息")
    @GetMapping(value = "/getMsg")
    public RestResponse<List<Msg>> getMsg() {

        List<Msg> msgVOList = userService.getMsg();
        return RestResponse.success(msgVOList);
    }
}


