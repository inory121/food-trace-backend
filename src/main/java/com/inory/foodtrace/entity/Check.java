package com.inory.foodtrace.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("`check`")
public class Check implements Serializable {

    private static final long serialVersionUID = 2787013061374868843L;

    @TableId(type = IdType.ASSIGN_UUID)
    private String checkID;
    private String id;
    private String info;
    @TableField("`state`")
    private Integer state;

}
