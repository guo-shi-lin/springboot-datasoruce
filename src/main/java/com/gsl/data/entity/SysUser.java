package com.gsl.data.entity;

import java.io.Serializable;

/**
 * 用户信息表(SysUser)实体类
 *
 * @author makejava
 * @since 2020-08-10 15:07:44
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = -38873207424511781L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;
    /**
     * 头像路径
     */
    private String avatar;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}