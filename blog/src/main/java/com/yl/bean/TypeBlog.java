package com.yl.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 博客-类型
 * @author YL
 * @date 2019/9/24 17:41
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TypeBlog implements Serializable {
    private static final long serialVersionUID = 1200338290369132833L;
    /**博文id*/
    private Integer blogId;

    /**类型id*/
    private Integer typeId;

}