package com.example.demo.entity;

import lombok.Data;
import java.util.Date;

@Data
public class User {
private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date createTime;
    private Date updateTime;
    private Integer version;
    private Integer deleted;
}
