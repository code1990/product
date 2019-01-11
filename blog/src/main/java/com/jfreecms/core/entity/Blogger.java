package com.jfreecms.core.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: blog
 * @Date: 2019/1/11 0011 11:46
 * @Author: Mr.Deng
 * @Description: 定义博主信息
 */
@Entity
@Table(name="t_user")
public class Blogger  {

    @Id
    private String id;

    @NotEmpty(message = "请输入用户名!")
    @Column(length=160)
    private String userName;

    @NotEmpty(message = "清楚输入密码!")
    @Column(length=160)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
