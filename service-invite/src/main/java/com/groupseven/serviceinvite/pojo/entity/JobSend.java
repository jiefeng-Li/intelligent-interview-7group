package com.groupseven.serviceinvite.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@TableName("qlm_job_send")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSend {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer jobId;
    private Integer resumeId;
    private LocalDateTime send_time;
    private String viewed;
    private String status;
}
