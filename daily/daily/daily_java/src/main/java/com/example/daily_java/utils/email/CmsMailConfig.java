package com.example.daily_java.utils.email;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "cms_mail_config")
public class CmsMailConfig {
    /**
     * 主键
     */
    @Id
    @Column(name = "MAIL_ID")
    private Integer mailId;

    /**
     * 邮箱账号
     */
    @Column(name = "MAIL_ACCOUNT")
    private String mailAccount;

    /**
     * 授权码
     */
    @Column(name = "MAIL_LICENSE")
    private String mailLicense;

    public CmsMailConfig(Integer mailId, String mailAccount, String mailLicense) {
        this.mailId = mailId;
        this.mailAccount = mailAccount;
        this.mailLicense = mailLicense;
    }

    public Integer getMailId() {
        return mailId;
    }

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    public String getMailAccount() {
        return mailAccount;
    }

    public void setMailAccount(String mailAccount) {
        this.mailAccount = mailAccount;
    }

    public String getMailLicense() {
        return mailLicense;
    }

    public void setMailLicense(String mailLicense) {
        this.mailLicense = mailLicense;
    }
}