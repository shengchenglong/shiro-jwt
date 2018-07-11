package com.scl.auth.controller;

import com.scl.auth.bean.ResponseBean;
import com.scl.auth.util.JWTUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shengchenglong
 * @Date: 2018/7/11 14:51
 */
@RestController
public class TestController {

    @GetMapping("/manage/login")
    public ResponseBean manageLogin(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(JWTUtil.sign(username, password));
        return responseBean;
    }
}
