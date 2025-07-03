package com.groupseven.serviceinvite.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invite {
    private Integer id;
    private Integer jobId;
    private Integer resumeId;
    private String content;
    private LocalDateTime inviteTime;
    private String reply;
}
