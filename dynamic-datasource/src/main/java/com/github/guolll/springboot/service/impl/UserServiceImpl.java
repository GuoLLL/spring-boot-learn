package com.github.guolll.springboot.service.impl;

import com.github.guolll.springboot.domain.User;
import com.github.guolll.springboot.mapper.test2.UserMapper;
import com.github.guolll.springboot.mybatis.DS;
import com.github.guolll.springboot.mybatis.DataSourceType;
import com.github.guolll.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mr.L on 2018/1/5 0005.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @DS(DataSourceType.test2Ds)
    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
