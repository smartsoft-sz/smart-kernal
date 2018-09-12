package com.smart.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200, "sucess"),//成功
    FAIL(400, "失败"),//失败
    UNAUTHORIZED(401, "未认证（签名错误）"),//未认证（签名错误）
    NOT_FOUND(404, "接口不存在"),//接口不存在


    GET_WX_USERINFO_FAILED(700, "获取微信用户信息失败"),
    GET_WX_BASE_ACCESS_TOKEN_FAILED(701, "获取微信基础access_token失败"),
    WX_UNLAWED_LOGIN(702, "非法登录"),
    GENERATE_WX_JSAPI_SIGNATURE_FAILED(703, "生成JSAPI Signature 失败"),
    GET_WX_OAUTH_ACCESS_TOKEN_FAILED(704, "获取微信OAUTH access_token失败"),
    CALL_WX_ABNORMAL (705,"访问微信异常"),

    ORDER_INEXIST(803,"订单不存在"),
    ORDER_ALREADY_PAY(815,"订单不存在"),
    PROD_SKU_NO_EXIT(827,"产品不存在"),
    CUB_PACK_NO_EMPTY(825,"柜子已满"),
    CUB_RESOURCE_UPLOAD_FAILED(826,"柜子软件更新资源上传失败"),
    CUB_NO_EXIT(828,"柜子不存在"),
    STORE_CODE_NO_EXIT(829,"开柜凭证无效"),
    ORDER_NULL(812,"订单为空"),
    SERIAL_NUM_EXIST(804,"该编号已经存在"),
    USER_EXIST(800, "账号已存在"),
    USER_NAME_NO_EXIST(801,"账号不存在"),
    PHONE_OPENID_NO_UNIFORMITY(814,"当前微信和输入的手机号未绑定"), // 输入的手机号和openid绑定的手机号不一致
    BARCODE_CAN_NOT_USED(805,"该条形码不存在或者已经被使用"),//条形码不存在或者已经被使用,
    USER_NOT_BIND_TO_CURRENT_WECHAT(802, "登录名错误"), //该账号没有绑定到当前微信号
    USER_NAME_NO_EMPLOYEE(806,"员工不存在"),
    USERBALANCE_NOT_ENOUGH(810,"用户账户余额不足"),
    USERBALANCE_NOT_EXIST(807,"该用户目前无余额账户"),
    PAYMENT_SUCCESS(811,"付款已成功"),
    ORDER_WECHAT_PAY_FAILED(812,"微信支付失败"),
    ORDER_WECHAT_OPENID_NOT_EXIST(813,"微信支付失败"),
    USER_DISPATCH_HIST_NOT_EXIST(8012,"配送历史记录不存在"),
    USER_RECHARGE_MONEY_EXCEED_THE_LIMIT(820,"用户充值金额超出限定"),
    WECHAT_HAS_ALREADY_BIND_ANOTHER_MOBILE(808,"该微信已绑定另一个手机号"),
    NO_WASH_BARCODE(830,"水洗码未打印无法出库"),


    VERIFY_CODE_ERROR(900, "手机号或者短信验证码错误"),
    VERIFY_CODE_USED(901, "验证码已被使用"),
    VERIFY_CODE_EXPIRED(902, "短信验证码过期"),
    USER_PHONE_USED(903, "该手机号已被注册过"),
    VERIFY_CODE_EXCEED_MAX_TIME(904, "发送验证码超过当日发送次数"),

    ASSOCIATED_DELETION_ERRO(905, "关联删除错误"),

    USER_NOT_EXIST(950, "用户不存在"),


    INTERNAL_SERVER_ERROR(500, "服务器内部错误"), //服务器内部错误


    VALIDATE_TOKEN_FAILED(999, "登录信息已失效"), //账号不存在， 或者token失效等

    ;
    private Integer code;
    private String msg;

    ResultCode(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
