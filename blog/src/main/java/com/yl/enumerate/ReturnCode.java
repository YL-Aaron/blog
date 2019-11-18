package com.yl.enumerate;

/**
 * @author yi
 * @desciption api状态枚举
 * @date 2019/11/18
 */
public enum ReturnCode {

    /**
     * 标注成功
     * @author yl
     * @date 2019/11/18 23:20
     */
    SUCCESS("成功", 200),
    /**
     * 标注失败
     * @author yl
     * @date 2019/11/18 23:21
     */
    FAIL("失败", 500);

    private String msg;
    private Integer code;

    ReturnCode(String msg, Integer code) {
        this.msg = msg;
        this.code = code;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
