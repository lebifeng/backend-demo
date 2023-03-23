package com.bifengle.demo.user.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user_base_info
 */
@Data
public class UserInfo implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String phone;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer age;

    /**
     *
     */
    private String address;

    private static final long serialVersionUID = 1L;
}