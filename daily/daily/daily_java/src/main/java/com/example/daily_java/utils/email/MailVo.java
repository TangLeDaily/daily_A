package com.example.daily_java.utils.email;

import lombok.Data;

/**
 * @author Wayne
 * @date 2019/6/24
 */
@Data
public class MailVo {
    /**
     * 邮件标题
     */
    private String mailTiTle;
    /**
     * 邮件内容
     */
    private String mailContent;
    /**
     * 收件人(们)
     */
    private String recipients;

    public MailVo(String mailTiTle, String mailContent, String recipients) {
        this.mailTiTle = mailTiTle;
        this.mailContent = mailContent;
        this.recipients = recipients;
    }

    public String getMailTiTle() {
        return mailTiTle;
    }

    public void setMailTiTle(String mailTiTle) {
        this.mailTiTle = mailTiTle;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }
}