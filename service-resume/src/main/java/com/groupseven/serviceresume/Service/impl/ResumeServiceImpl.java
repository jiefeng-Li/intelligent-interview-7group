package com.groupseven.serviceresume.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.groupseven.serviceresume.Mapper.EdubgMapper;
import com.groupseven.serviceresume.Mapper.ResumeMapper;
import com.groupseven.serviceresume.Mapper.WorkexpMapper;
import com.groupseven.serviceresume.Service.ResumeService;
import com.groupseven.serviceresume.pojo.DTO.EduDTO;
import com.groupseven.serviceresume.pojo.DTO.ResumeDTO;
import com.groupseven.serviceresume.pojo.DTO.WorkDTO;
import com.groupseven.serviceresume.pojo.VO.ResumeListVO;
import com.groupseven.serviceresume.pojo.VO.ResumeViewVO;
import com.groupseven.serviceresume.pojo.entity.Edubg;
import com.groupseven.serviceresume.pojo.entity.Resume;
import com.groupseven.serviceresume.pojo.entity.Workexp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private WorkexpMapper workexpMapper;
    @Autowired
    private EdubgMapper edubgMapper;

    @Override
    public void del(String userid, Integer id) throws Exception {
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userid);
        queryWrapper.eq("id",id);
        Resume resume = resumeMapper.selectOne(queryWrapper);
        if(resume==null)throw new Exception("简历不存在");
        resume.setIsDeleted("1");
        resumeMapper.updateById(resume);
        queryWrapper.clear();
        queryWrapper.eq("user_id",userid);
        queryWrapper.eq("is_deleted","0");
        if(resume.getDef().equals("1")){
            List<Resume> resumes = resumeMapper.selectList(queryWrapper);
            if(resumes!=null&& !resumes.isEmpty()){
                resumes.getFirst().setDef("1");
                resumeMapper.updateById(resumes.getFirst());
            }
        }
    }

    @Override
    public void def(String userid, Integer id) throws Exception {
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userid);
        queryWrapper.eq("id",id);
        Resume resume = resumeMapper.selectOne(queryWrapper);
        if(resume==null||resume.getIsDeleted().equals("1"))throw new Exception("简历不存在");
        queryWrapper.clear();
        queryWrapper.eq("user_id",userid);
        queryWrapper.eq("def","1");
        queryWrapper.eq("is_deleted","0");
        Resume resume1 = resumeMapper.selectOne(queryWrapper);
        if(resume1!=null)resume1.setDef("0");
        resume.setDef("1");
        resumeMapper.updateById(resume);
        resumeMapper.updateById(resume1);
    }

    @Override
    public List<ResumeListVO> list(String userid) {
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userid);
        queryWrapper.eq("is_deleted","0");
        List<Resume> resumes = resumeMapper.selectList(queryWrapper);
        List<ResumeListVO> list=new ArrayList<>();
        for(Resume resume:resumes){
            ResumeListVO resumeListVO=new ResumeListVO();
            BeanUtils.copyProperties(resume,resumeListVO);
            list.add(resumeListVO);
        }
        return list;
    }

    @Override
    public ResumeViewVO view(Integer id) throws RuntimeException{
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Resume resume = resumeMapper.selectOne(queryWrapper);
        if(resume==null||resume.getIsDeleted().equals("1"))throw new RuntimeException("简历不存在");
        QueryWrapper<Workexp> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("resume_id",id);
        List<Workexp> workexps = workexpMapper.selectList(queryWrapper1);
        QueryWrapper<Edubg> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.eq("resume_id",id);
        List<Edubg> edubgs = edubgMapper.selectList(queryWrapper2);
        ResumeViewVO resumeViewVO=new ResumeViewVO();
        BeanUtils.copyProperties(resume,resumeViewVO);
        resumeViewVO.setWorkexpList(workexps);
        resumeViewVO.setEdubgList(edubgs);
        return resumeViewVO;
    }

    @Override
    public void addedu(String userid, EduDTO eduDTO) throws Exception {
        Edubg edubg = new Edubg();
        BeanUtils.copyProperties(eduDTO,edubg);
        if(eduDTO.getResumeId()==null){
            throw new Exception("简历不存在");
        }
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userid);
        queryWrapper.eq("id",eduDTO.getResumeId());
        Resume resume = resumeMapper.selectOne(queryWrapper);
        if(resume==null||resume.getIsDeleted().equals("1"))throw new Exception("简历不存在");
        edubg.setSort((int) (edubgMapper.selectCount(null)+1));
        edubgMapper.insert(edubg);
    }
    public void addwork(String userid, WorkDTO workDTO) throws Exception{
        Workexp workexp = new Workexp();
        BeanUtils.copyProperties(workDTO,workexp);
        if(workDTO.getResumeId()==null){
            throw new Exception("简历不存在");
        }
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userid);
        queryWrapper.eq("id",workDTO.getResumeId());
        Resume resume = resumeMapper.selectOne(queryWrapper);
        if(resume==null||resume.getIsDeleted().equals("1"))throw new Exception("简历不存在");
        workexp.setSort((int) (workexpMapper.selectCount(null)+1));
        workexpMapper.insert(workexp);
    }

    @Override
    public int addresume(String userid, ResumeDTO resumeDTO) {
        LambdaQueryWrapper<Resume> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Resume::getUserId,userid);
        queryWrapper.eq(Resume::getIsDeleted,"0");
        Long count= resumeMapper.selectCount(queryWrapper);
        Resume resume=new Resume();
        BeanUtils.copyProperties(resumeDTO,resume);
        resume.setCreatedTime(LocalDateTime.now());
        resume.setRefreshTime(LocalDateTime.now());
        resume.setDef("0");
        resume.setViewNum(0);
        resume.setFavorNum(0);
        if(count==0)resume.setDef("1");
        resume.setIsDeleted("0");
        resume.setStatus("0");
        resume.setUserId(Integer.valueOf(userid));
        resumeMapper.insert(resume);
        return resume.getId();
    }

    @Override
    public void refresh(Integer resumeid) throws Exception {
        LambdaQueryWrapper<Resume> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Resume::getId,resumeid);
        Resume resume = resumeMapper.selectOne(queryWrapper);
        if(resume==null||resume.getIsDeleted().equals("1"))throw new Exception("简历不存在");
        resume.setRefreshTime(LocalDateTime.now());
        resumeMapper.updateById(resume);
    }
}
