package com.yl.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yi
 * @desciption 文章类
 * @date 2019/8/13
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Blog extends Base implements Serializable {
    private Integer id;

    private String title;

    private Integer isShow;

    private String img;

    private String content;

}