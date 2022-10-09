package com.java.wikipedia.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private String title;

    private String writing;

    private TopicDto topic;

    private MemberDto author;

    private Date createdTime;

    private Date updateTime;
}
