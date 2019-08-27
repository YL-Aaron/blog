package com.yl.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yi
 * @desciption 用户类
 * @date 2019/8/13
 */
@Data
@NoArgsConstructor
public class User {
    private Integer id;

    private String username;

    private String password;

    private String img;

    private Date createtime;

    private Date updatetime;

}