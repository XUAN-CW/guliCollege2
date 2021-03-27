package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试 逻辑删除
     */
    @Test
    public void testLogicDelete() {

        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }

    /**
     * 测试 逻辑删除后的查询：
     * 不包括被逻辑删除的记录
     */
    @Test
    public void testLogicDeleteSelect() {
        User user = new User();
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
