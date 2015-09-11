package com.learn.ssh.model;

import javax.persistence.*;

/**
 * 管理员权限表
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 16:00
 * @since jdk1.6.0_27
 */
@Entity(name = "AdminAuthority")
@Table(name = "admin_authority")
public class AdminAuthority {

    private Integer id;
    private String username;
    private String role;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false,insertable = true,updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username",unique = true,nullable = false,insertable = true,updatable = true,length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "role",unique = false,nullable = false,insertable = true,updatable = true,length = 100)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Transient
    @Override
    public String toString() {
        return "AdminAuthority{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
