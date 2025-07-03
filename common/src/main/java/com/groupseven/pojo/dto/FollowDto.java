package com.groupseven.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("qlm_follow")
public class FollowDto {
    @TableId(type = IdType.AUTO)
    private int id;
    private int entId;
    private int userId;
    private LocalDateTime followTime;
}
