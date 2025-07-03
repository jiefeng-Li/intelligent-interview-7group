package com.groupseven.serviceinvite.pojo.vo;

import com.groupseven.pojo.dto.JobDto;
import com.groupseven.pojo.dto.ResumeDto;
import com.groupseven.serviceinvite.pojo.dto.InviteDto;
import com.groupseven.serviceinvite.pojo.dto.JobSendDto;
import lombok.Data;

@Data
public class ResumeVo {
    private String avatar;
    private ResumeDto resumeDto;
    private JobSendDto jobSendDto;
    private InviteDto inviteDto;
    private JobDto jobDto;
}
