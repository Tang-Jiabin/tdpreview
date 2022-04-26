package com.example.tdpreview.webscoket;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageRequest implements Serializable {

    private Long uid;
    private Long tid;
    private Integer type;
//    private Integer current = 1;
//
//    private Integer size = 10;

    private String msg;

    private String name;

    private String pwd;

}
