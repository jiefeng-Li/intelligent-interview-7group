package com.groupseven.serviceinvite.pojo.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)public class EIPageDto extends PageDto {
    // 公司id
    private Integer id;
}
