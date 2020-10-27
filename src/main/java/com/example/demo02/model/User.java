package com.example.demo02.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

   // @Column(name = "id")
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 手机号码
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 邮件地址
     */
    @Column(name = "email")
    private String email;
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}