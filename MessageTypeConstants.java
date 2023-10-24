package com.kkb.core.message;

public class MessageTypeConstants {

    public static final String DINGTALK = "dingtalk";

    public static final String SMS = "sms";

    public static final String MI_DUI_SMS = "mi_dui_sms";

    public static final String MAIL = "mail";

    public static final String WECHAT_TEMPLATE = "wechat_template";

    public static final String WECHAT_CUSTOMER= "wechat_customer";

    public static final String STUDENT_MESSAGE= "student_message";

    public static final String DEAD_LETTER = "dead_letter";

    /**
     * 短信类型 0 : 文字短信 1 : 语音短信
     */
    public enum MessageType{
        MESSAGE,
        MESSAGE_VIOCE;
    }

}
