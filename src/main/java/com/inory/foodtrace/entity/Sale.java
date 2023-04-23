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
public class Sale implements Serializable {

    private static final long serialVersionUID = -5114841995965448794L;


    private String salesInfoId;
    private String enterName;
    private String enterPosit;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date storageTime;
    private String storageTeHu;
    private String salesSite;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shelfTime;
    private String operatorId;
    @ToString.Exclude
    private String hash;
    @ToString.Exclude
    private Integer state;

}
