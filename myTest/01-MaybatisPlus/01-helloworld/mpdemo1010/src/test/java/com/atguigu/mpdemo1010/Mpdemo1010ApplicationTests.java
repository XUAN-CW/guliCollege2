package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mpdemo1010ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //查询user表所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
