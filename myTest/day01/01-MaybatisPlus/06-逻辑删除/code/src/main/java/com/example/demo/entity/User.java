package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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
    @TableLogic
    private Integer deleted;
}
