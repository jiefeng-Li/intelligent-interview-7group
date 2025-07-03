package com.groupseven.serviceinvite.pojo.dto;


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
@TableName("qlm_job_send")
public class JobSendDto {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer jobId;
    private Integer resumeId;
    private LocalDateTime sendTime;
    private String viewed;
    private String status;
}

