package com.smart.service.dto;

import javax.validation.constraints.NotNull;

public class UserDTO {

    private String openid;
    @NotNull(message = "手机号必填")
    private String mobile;
    @NotNull(message = "短信验证码必填")
    private String verifyCode;
    @NotNull(message = "密码必填")
    private String password;
    private String recommendPhone;

    private String type;

    private String loginName;

    private String name;

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecommendPhone() {
        return recommendPhone;
    }

    public void setRecommendPhone(String recommendPhone) {
        this.recommendPhone = recommendPhone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDTO{");
        sb.append("openid='").append(openid).append('\'');
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", verifyCode='").append(verifyCode).append('\'');
        sb.append(", recommendPhone='").append(recommendPhone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
