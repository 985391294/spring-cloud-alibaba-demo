package com.tqz.common.base;

/**
 * <p>
 * 公共返回状态码
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/25 11:15
 */
public enum ReturnCode {

    RC100(200, "请求成功"),
    RC999(500, "操作失败"),
    RC403(403, "匿名用户访问无权限资源时的异常"),
    RC401(401, "认证用户访问无权限资源时的异常");

    /**
     * 自定义状态码
     */
    private int code;

    /**
     * 自定义描述
     */
    private String message;

    private ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
