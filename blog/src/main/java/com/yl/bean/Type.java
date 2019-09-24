package com.yl.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yi
 * @desciption 博客类型
 * @date 2019/8/13
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Type extends Base implements Serializable {
    private Integer id;

    private String name;

    private Date createTime;

    private Date updateTime;

}