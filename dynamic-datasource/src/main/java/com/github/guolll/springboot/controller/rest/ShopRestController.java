package com.github.guolll.springboot.controller.rest;

import com.github.guolll.springboot.domain.Shop;
import com.github.guolll.springboot.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr.L on 2018/1/5 0005.
 */
@RestController
@RequestMapping("/shop")
@Api("商品操作类")
public class ShopRestController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation("根据商品编号获得商品信息")
    @ApiImplicitParam(name = "id", value = "商品编号", dataType = "int", paramType = "path", required = true)
    public Shop get(@PathVariable int id) {
        return shopService.get(id);
    }
}
