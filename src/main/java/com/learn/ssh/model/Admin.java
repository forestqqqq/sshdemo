package com.learn.ssh.model;

import javax.persistence.*;

/**
 * 管理员表
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 14:55
 * @since jdk1.6.0_27
 */
@Entity(name = "Admin")
@Table(name = "admin")
public class Admin {


    public Long userId;
    private String username;
    private String password;
    private String name;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false,insertable = true,updatable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "username",unique = true,nullable = false,insertable = true,updatable = true,length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password",unique = false,nullable = false,insertable = true,updatable = true,length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name",unique = false,nullable = true,insertable = true,updatable = true,length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    @Override
    public String toString() {
        return "Admin{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
