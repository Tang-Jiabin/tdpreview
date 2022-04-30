package com.example.tdpreview.service.impl;

import java.time.Instant;

import com.example.tdpreview.common.APIException;
import com.example.tdpreview.dao.MsgRepository;
import com.example.tdpreview.dao.UserRepository;
import com.example.tdpreview.pojo.Msg;
import com.example.tdpreview.pojo.User;
import com.example.tdpreview.service.UserService;
import com.example.tdpreview.vo.MsgVO;
import com.example.tdpreview.vo.UserInfoVO;
import com.example.tdpreview.webscoket.MessageRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final MsgRepository msgRepository;

    public UserServiceImpl(UserRepository userRepository, MsgRepository msgRepository) {
        this.userRepository = userRepository;
        this.msgRepository = msgRepository;
    }

    @Override
    public Optional<User> socketLogin(MessageRequest messageRequest) {
        String name = messageRequest.getName();
        String pwd = messageRequest.getPwd();
        return userRepository.findByNameAndPwd(name, pwd);

    }

    @Override
    public UserInfoVO login(UserInfoVO userInfoVO) {
        Optional<User> userOptional = userRepository.findByNameAndPwdOrNoAndPwd(userInfoVO.getName(), userInfoVO.getPwd(), userInfoVO.getName(), userInfoVO.getPwd());
        if (userOptional.isPresent()) {
            BeanUtils.copyProperties(userOptional.get(), userInfoVO);
            userInfoVO.setPwd("******");
            return userInfoVO;
        }
        throw new APIException(400, "用户名或密码错误");
    }

    @Override
    public UserInfoVO register(UserInfoVO userInfoVO) {
        Optional<User> userOptional = userRepository.findByNo(userInfoVO.getNo());
        if (userOptional.isEmpty()) {
            User user = new User();
            user.setName(userInfoVO.getName());
            user.setPwd(userInfoVO.getPwd());
            user.setNo(userInfoVO.getNo());
            user.setCtime(Instant.now());
            user.setState(1);
            User save = userRepository.save(user);
            BeanUtils.copyProperties(save, userInfoVO);
            return userInfoVO;
        }
        throw new APIException(400, "该学号已注册");
    }

    @Override
    public void sendMsg(MsgVO msgVO) {
        Msg msg = new Msg();
        BeanUtils.copyProperties(msgVO, msg);
        msgRepository.save(msg);
    }

    @Override
    public List<Msg> getMsg() {


        return msgRepository.findAll();
    }


}
