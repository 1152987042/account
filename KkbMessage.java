package com.kkb.core.message;

public interface KkbMessage {

    String getRecipient();

    Object getContent();

    String getTemplate();

    String getType();

    void setTemplate(String template);

}
