package com.scl.auth.shiro;

/**
 * 请求类型
 *
 * @author shengchenglong
 */
public enum RequestType {

    /**
     * 管理端登录请求
     */
    MANAGE_LOGIN,

    /**
     * 管理端操作请求
     */
    MANAGE_REQUEST,

    /**
     * 学员端登录请求
     */
    FRONT_LOGIN,

    /**
     * 学员端操作请求
     */
    FRONT_REQUEST

}
