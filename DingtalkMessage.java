package com.kkb.core.message;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class DingtalkMessage extends AbstractMessage {
    private static final long serialVersionUID = 5840275348720502648L;

    private Map<String, Object> content;

    private void setMsgtype(String value) {
        addNode("msgtype", value);
    }

    /**
     * 文本消息
     *
     * @param value
     */
    public void setText(String value) {
        setMsgtype(DingtalkConstants.CustomerMsgType.TEXT);
        Map<String, Object> map = Maps.newHashMap();
        map.put("content", value);
        addNode(DingtalkConstants.CustomerMsgType.TEXT, map);
    }

    /**
     * 卡片消息
     * 整体跳转ActionCard样式参数
     *
     * @param title        透出到会话列表和通知的文案
     * @param markdown     消息内容，支持markdown，语法参考标准markdown语法。
     * @param single_title 使用整体跳转ActionCard样式时的标题，必须与single_url同时设置
     * @param single_url   消息点击链接地址，当发送消息为E应用时支持E应用跳转链接
     */
    public void setActionCard(String title, String markdown, String single_title, String single_url) {
        setMsgtype(DingtalkConstants.CustomerMsgType.ACTION_CARD);
        Map<String, Object> map = Maps.newHashMap();
        map.put("title", title);
        map.put("markdown", markdown);
        map.put("single_title", single_title);
        map.put("single_url", single_url);
        addNode(DingtalkConstants.CustomerMsgType.ACTION_CARD, map);
    }

    /**
     * 卡片消息
     * 独立跳转ActionCard样式参数
     *
     * @param title           透出到会话列表和通知的文案
     * @param markdown        消息内容，支持markdown，语法参考标准markdown语法。
     * @param btn_orientation 使用独立跳转ActionCard样式时的按钮排列方式，竖直排列(0)，横向排列(1)；必须与btn_json_list同时设置
     * @param btn_json_list   参数：title、action_url
     */
    public void setActionCard(String title, String markdown, String btn_orientation, List<Map<String, Object>> btn_json_list) {
        setMsgtype(DingtalkConstants.CustomerMsgType.ACTION_CARD);
        Map<String, Object> map = Maps.newHashMap();
        map.put("title", title);
        map.put("markdown", markdown);
        map.put("btn_orientation", btn_orientation);
        map.put("btn_json_list", btn_json_list);
        addNode(DingtalkConstants.CustomerMsgType.ACTION_CARD, map);
    }

    private void addNode(String nodeName, Object value) {
        if (content == null) {
            content = Maps.newLinkedHashMap();
        }
        content.put(nodeName, value);
    }

    @Override
    public Object getContent() {
        return content;
    }

    @Override
    public String getType() {
        return MessageTypeConstants.DINGTALK;
    }
}
