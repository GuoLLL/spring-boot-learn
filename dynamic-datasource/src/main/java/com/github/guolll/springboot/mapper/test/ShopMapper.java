package com.github.guolll.springboot.mapper.test;

import com.github.guolll.springboot.domain.Shop;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}