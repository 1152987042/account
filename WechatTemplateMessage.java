package com.kkb.core.message;

import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 放这里是为了兼容message
 */
public class WechatTemplateMessage extends AbstractMessage {

    private static final long serialVersionUID = 3070212000032149622L;
    private String appid;

    private Map<String, Object> content;

    private String url;

    private AtomicInteger count;

    private String templeteId;

    public static final String WECHAT_TEMPLATE = "wechat_template";

    @Override
    public Object getContent() {
        return content;
    }

    @Override
    public String getType() {
        return WECHAT_TEMPLATE;
    }

    public void setMark(String value) {
        setMark(value, null);
    }

    public void setMark(String value, String color) {
        addNode("remark", value, color);
    }

    public void setFirst(String value) {
        setFirst(value, null);
    }

    public void setFirst(String value, String color) {
        addNode("first", value, color);
    }

    public void addKeyword(String value, String color) {
        if (count == null) {
            count = new AtomicInteger();
        }
        int i = count.incrementAndGet();
        addNode("keyword" + i, value, color);
    }

    public void addOrderType(String value, String color) {
        addNode("orderType", value, color);
    }

    public void addReMark(String value, String color) {
        addNode("remark", value, color);
    }


    public void addDateTime(String value, String color) {
        addNode("tradeDateTime", value, color);
    }

    public void addCustomerInfo(String value, String color) {
        addNode("customerInfo", value, color);
    }


    public void addKeyword(String value) {
        addKeyword(value, null);
    }

    private void addNode(String nodeName, String value, String color) {
        if (content == null) {
            content = Maps.newLinkedHashMap();
        }
        Map<String, String> map = Maps.newHashMap();
        map.put("value", value);
        if (!StringUtils.isEmpty(color)) {
            map.put("color", color);
        }
        content.put(nodeName, map);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

    public String getTempleteId() {
        return templeteId;
    }

    public void setTempleteId(String templeteId) {
        this.templeteId = templeteId;
    }
}
