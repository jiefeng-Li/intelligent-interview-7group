package com.groupseven.serviceresume.Service;

import com.groupseven.serviceresume.pojo.DTO.EduDTO;
import com.groupseven.serviceresume.pojo.DTO.ResumeDTO;
import com.groupseven.serviceresume.pojo.DTO.WorkDTO;
import com.groupseven.serviceresume.pojo.VO.ResumeListVO;
import com.groupseven.serviceresume.pojo.VO.ResumeViewVO;

import java.util.List;

public interface ResumeService {
    void del(String userid, Integer id) throws Exception;

    void def(String userid, Integer id) throws Exception;

    List<ResumeListVO> list(String userid);

    ResumeViewVO view(Integer id);

    void addedu(String userid, EduDTO eduDTO) throws Exception;

    public void addwork(String userid, WorkDTO workDTO) throws Exception;

    int addresume(String id, ResumeDTO resume);

    void refresh(Integer resumeid) throws Exception;
}
