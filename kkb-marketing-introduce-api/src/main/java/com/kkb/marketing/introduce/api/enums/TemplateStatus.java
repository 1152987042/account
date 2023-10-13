package com.kkb.marketing.introduce.api.enums;

import com.kkb.framework.core.enums.KkbWebStatus;

import java.util.HashMap;

/**
 * @author zhaodahai
 * 2021/8/25
 */
public enum TemplateStatus implements KkbWebStatus {
    /**
     * 业务异常
     */
    TEMPLATE_BUSINESS_EXCEPTION(10099, "Template业务异常"),
    ;

    private final int code;

    private final String msg;

    TemplateStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    private static HashMap<Integer, TemplateStatus> map = new HashMap<>(32);

    static {
        for (TemplateStatus d : TemplateStatus.values()) {
            map.put(d.code, d);
        }
    }

    /**
     * 根据code返回TemplateStatus
     *
     * @param code
     * @return
     */
    public static TemplateStatus parse(int code) {
        if (map.containsKey(code)) {
            return map.get(code);
        }
        return null;
    }


}
