package com.groupseven.serviceresume.pojo.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author 老谭（<a href="http://www.woniuxy.com">蜗牛学苑</a>）
 */
@Data
public class Resume {
    public String intent;
    public LocalDate birthdate;
}
