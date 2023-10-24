package com.kkb.core.message;

/**
 * 钉钉信息通知
 * 消息类型与数据格式
 */
public class DingtalkConstants {
    public static class CustomerMsgType {
        /**
         * 文本消息
         */
        public static final String TEXT = "text";
        /**
         * 图片消息
         */
        public static final String IMAGE = "image";
        /**
         * 语音消息
         */
        public static final String VOICE = "voice";
        /**
         * 文件消息
         */
        public static final String FILE = "file";
        /**
         * 链接消息
         */
        public static final String LINK = "link";
        /**
         * OA消息
         */
        public static final String OA = "oa";
        /**
         * markdown消息
         */
        public static final String MARKDOWN = "markdown";
        /**
         * 卡片消息
         */
        public static final String ACTION_CARD = "action_card";
        /**
         * 卡片消息-新
         */
        public static final String ACTIONCARD = "actionCard";
    }
}
