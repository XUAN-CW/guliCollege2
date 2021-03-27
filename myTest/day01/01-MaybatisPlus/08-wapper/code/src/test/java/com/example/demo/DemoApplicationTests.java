package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    //mp实现复杂查询操作
    @Test
    public void testSelectQuery() {
        //创建QueryWrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //通过QueryWrapper设置条件
        //ge、gt、le、lt
        //查询age>=30记录
        //第一个参数字段名称，第二个参数设置值
        //wrapper.ge("age",30);

        //eq、ne
        //wrapper.eq("name","lilei");
        //wrapper.ne("name","lilei");

        //between
        //查询年龄 20-30
         wrapper.between("age",20,30);

        //like
        //wrapper.like("name","岳");

        //orderByDesc
        // wrapper.orderByDesc("id");

        //last
        //wrapper.last("limit 1");

        //指定要查询的列
//        wrapper.select("id","name");

        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

}
