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
public class Butcher implements Serializable {

    private static final long serialVersionUID = 9104565510904420487L;

    private String pigId;
    private String healthStatu;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date quaranDate;
    private String porkBatches;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date slaDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acidTime;
    private String ambientTeHu;
    private String packId;
    private String packMaterial;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date packTime;
    private String meatPart;
    private String operatorId;
    @ToString.Exclude
    private String hash;
    @ToString.Exclude
    private Integer state;

}
