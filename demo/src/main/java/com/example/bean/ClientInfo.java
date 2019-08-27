package com.example.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("ALL")
@Data
@Document("clientInfo")
public class ClientInfo implements Serializable {
    private static final long serialVersionUID = -2877325960100767018L;

    private String clientId;
    private short connected;
    private Long mostsignbits;
    private Long leastsignbts;
    private Date lastconnecteddate;
}
