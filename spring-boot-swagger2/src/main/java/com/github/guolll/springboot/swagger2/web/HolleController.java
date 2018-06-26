package com.github.guolll.springboot.swagger2.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by Mr.L on 2017/4/6 0006.
 */
@RestController
public class HolleController {

    @ApiIgnore
    @RequestMapping(value = "/")
    public String hello() {
        return "hello word";
    }
}
