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
public class Farm implements Serializable {

    private static final long serialVersionUID = 3994904426271475521L;


    private String farmId;
    private String farmPosit;
    private String farmOwner;
    private String ehygiene;
    private String pigId;
    private String pigType;
    private String pigGender;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cultTime;
    private String feedType;
    private String vaccineType;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date vaccineTime;
    private String operatorId;
    @ToString.Exclude
    private String hash;
    @ToString.Exclude
    private Integer state;

//    @Override
//    public String toString() {
//        return "Farm{" +
//                "farmId='" + farmId + '\'' +
//                ", farmPosit='" + farmPosit + '\'' +
//                ", farmOwner='" + farmOwner + '\'' +
//                ", ehygiene='" + ehygiene + '\'' +
//                ", pigId='" + pigId + '\'' +
//                ", pigType='" + pigType + '\'' +
//                ", pigGender='" + pigGender + '\'' +
//                ", cultTime=" + cultTime +
//                ", feedType='" + feedType + '\'' +
//                ", vaccineType='" + vaccineType + '\'' +
//                ", vaccineTime=" + vaccineTime +
//                ", operatorId='" + operatorId + '\'' +
//                '}';
//    }
}
