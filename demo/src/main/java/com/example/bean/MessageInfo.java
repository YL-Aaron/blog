package com.example.bean;

import lombok.Data;

@Data
public class MessageInfo {
    private String sourceClientId;
    private String targetClientId;
    private String msgType;
    private String msgContent;
}
