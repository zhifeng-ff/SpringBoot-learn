package com.zpf.domain.query;

import com.zpf.domain.User;
import lombok.Data;

@Data
public class UserQuery extends User {

    //用来描述年龄上限
    private Integer age2;
}
