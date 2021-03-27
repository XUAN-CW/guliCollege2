package com.example.module.service.impl;

import com.example.module.entity.User;
import com.example.module.mapper.UserMapper;
import com.example.module.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuan
 * @since 2021-03-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
