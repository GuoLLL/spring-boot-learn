package com.github.guolll.springboot.swagger2.web;

import com.github.guolll.springboot.swagger2.domain.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Mr.L on 2017/4/6 0006.
 */
@Api(description = "用户操作类")
@RestController
@RequestMapping("/user")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());


    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 500, message = "服务器内部异常"),
            @ApiResponse(code = 302, message = "权限不足")})
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }


    @ApiOperation(value = "获取用户详细信息", notes = "根据URL中的id获取")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value = "新增用户")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, paramType = "body", dataType = "User")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public String createUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "修改用户", notes = "根据id修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User"),
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User user1 = users.get(id);
        user1.setAge(user.getAge());
        user1.setName(user.getName());
        users.put(id, user1);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

}
