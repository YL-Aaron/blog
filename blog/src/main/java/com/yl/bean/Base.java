package com.yl.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 定义实体基类
 * @author YL
 * @date 9:28 2019/9/20
 */
@Data
public class Base implements Serializable {

    private Date createTime;

    private Date updateTime;
}
