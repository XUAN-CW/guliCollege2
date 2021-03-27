package com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    //分页查询
    @Test
    public void testPage() {
        //1 创建page对象
        //传入两个参数：当前页 和 每页显示记录数
        Page<User> page = new Page<>(1,3);
        //调用mp分页查询的方法
        //调用mp分页查询过程中，底层封装
        //把分页所有数据封装到page对象里面
        userMapper.selectPage(page,null);

        //通过page对象获取分页数据
        System.out.println("当前页:"+page.getCurrent());
        System.out.println("每页数据list集合:"+page.getRecords());
        System.out.println("每页显示记录数:"+page.getSize());
        System.out.println("总记录数:"+page.getTotal());
        System.out.println("总页数:"+page.getPages());
        System.out.println("下一页:"+page.hasNext());
        System.out.println("上一页:"+page.hasPrevious());
    }
}
