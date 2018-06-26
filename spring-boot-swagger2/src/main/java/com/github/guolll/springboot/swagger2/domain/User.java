package com.github.guolll.springboot.swagger2.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Mr.L on 2017/4/6 0006.
 */
public class User {

    @ApiModelProperty(value = "id", required = true, allowableValues = "[1,100]")
    private Long id;
    @ApiModelProperty(value = "年龄", dataType = "数字")
    private Integer age;
    @ApiModelProperty("姓名")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
