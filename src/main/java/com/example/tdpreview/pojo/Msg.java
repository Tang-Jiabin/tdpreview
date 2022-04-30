package com.example.tdpreview.pojo;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "td_msg")
public class Msg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer uid;

    private String text;

    private String date;

    private String name;

    private Instant time;
}
