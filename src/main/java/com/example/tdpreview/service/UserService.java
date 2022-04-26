package com.example.tdpreview.service;

import com.example.tdpreview.pojo.User;
import com.example.tdpreview.vo.UserInfoVO;
import com.example.tdpreview.webscoket.MessageRequest;

import java.util.Optional;

public interface UserService {
    Optional<User> socketLogin(MessageRequest messageRequest);

    UserInfoVO login(UserInfoVO userInfoVO);

    UserInfoVO register(UserInfoVO userInfoVO);
}
