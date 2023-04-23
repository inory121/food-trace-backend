package com.inory.foodtrace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author inory
 * @create 2021-07-21 18:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 420557546922167754L;

    private Long id;
    private String name;
    private String password;
    private String role;
    private String avatar;

}
