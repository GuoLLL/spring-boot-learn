package com.github.guolll.springboot.controller.rest;

import com.github.guolll.springboot.domain.User;
import com.github.guolll.springboot.service.UserService;
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
@RequestMapping("/user")
@Api("用户操作")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation("根据用户编号获得用户信息")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = "int", paramType = "path", required = true)
    public User get(@PathVariable int id) {
        return userService.get(id);
    }
}
