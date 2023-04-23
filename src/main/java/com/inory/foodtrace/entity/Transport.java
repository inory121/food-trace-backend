package com.inory.foodtrace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transport implements Serializable {

    private static final long serialVersionUID = -8906541254635795413L;


    private String transportId;
    private String enterName;
    private String enterPosit;
    private String enterOwner;
    private String licenNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date transTime;
    private String transOrigin;
    private String transDestin;
    private String carriageTeHu;
    private String driverName;
    private String operatorId;
    @ToString.Exclude
    private String hash;
    @ToString.Exclude
    private Integer state;

}
