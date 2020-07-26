package com.yl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串帮助类
 *
 * @author YL
 * @date 10:43 2019/9/18
 */
public class StringUtil {

    /**
     * 将逗号分隔的字符串装换为List
     *
     * @param ids
     * @return java.util.List<java.lang.String>
     * @author YL
     * @date 2019/9/18 10:48
     */
    public static String[] ids(String ids) {
        String[] result = ids.split(",");
        return result;
    }

}
