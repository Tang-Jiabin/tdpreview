package com.example.tdpreview.service;

import com.example.tdpreview.pojo.Msg;
import com.example.tdpreview.pojo.User;
import com.example.tdpreview.vo.MsgVO;
import com.example.tdpreview.vo.UserInfoVO;
import com.example.tdpreview.webscoket.MessageRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> socketLogin(MessageRequest messageRequest);

    UserInfoVO login(UserInfoVO userInfoVO);

    UserInfoVO register(UserInfoVO userInfoVO);

    void sendMsg(MsgVO msgVO);

    List<Msg> getMsg();

}
