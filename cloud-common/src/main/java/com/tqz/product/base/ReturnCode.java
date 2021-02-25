package com.tqz.product.base;

/**
 * <p>
 * 公共返回状态码
 * </p
 *
 * @author tianqingzhao
 * @since 2021/2/25 11:15
 */
public enum ReturnCode {
    /**操作成功**/
    RC100(100,"请求成功"),
    /**操作失败**/
    RC999(999,"操作失败"),
    /**服务限流**/
    RC200(200,"服务开启限流保护,请稍后再试!"),
    /**服务降级**/
    RC201(201,"服务开启降级保护,请稍后再试!"),
    /**热点参数限流**/
    RC202(202,"热点参数限流,请稍后再试!"),
    /**系统规则不满足**/
    RC203(203,"系统规则不满足要求,请稍后再试!"),
    /**授权规则不通过**/
    RC204(204,"授权规则不通过,请稍后再试!"),
    /**access_denied**/
    RC403(403,"匿名用户访问无权限资源时的异常"),
    /**access_denied**/
    RC401(401,"认证用户访问无权限资源时的异常");

    /**自定义状态码**/
    private int code;
    /**自定义描述**/
    private String message;

    private ReturnCode(int code,String message){
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
