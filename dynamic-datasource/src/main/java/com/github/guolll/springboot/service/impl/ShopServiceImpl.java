package com.github.guolll.springboot.service.impl;

import com.github.guolll.springboot.domain.Shop;
import com.github.guolll.springboot.mapper.test.ShopMapper;
import com.github.guolll.springboot.mybatis.DS;
import com.github.guolll.springboot.mybatis.DataSourceType;
import com.github.guolll.springboot.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mr.L on 2018/1/5 0005.
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @DS(DataSourceType.testDs)
    public Shop get(Integer id) {
        return shopMapper.selectByPrimaryKey(id);
    }
}
