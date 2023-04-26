package com.zpf.domain;


import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("t_user")
public class User {

//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    @TableField(value = "pwd",select = false)
    private String password;
    private Integer age;
    private String tel;

    @TableField(exist = false)
    private Integer online;

    //逻辑删除字段  value:默认值  delval：删除后的值
//    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    @Version
    //乐观锁  自旋加一  version = version + 1
    private Integer version;


}
