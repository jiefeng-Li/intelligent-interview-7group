package com.groupseven.pojo.dto;

import lombok.Data;

import java.util.List;


@Data
public class EResumeDto {
    private Integer id; // employee id
    private List<ResumeDto> resumeDtoList;
}
