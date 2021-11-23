package com.ggs.starbug.po;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Starbug
 * @Date 2021/11/23 21:11
 */
@Data
@Accessors(chain = true)
@Builder
public class User {

    private String name;

    private String sex;

    private Integer age;

}
