package com.java.wikipedia.Service;

import com.java.wikipedia.Dto.ProjectDto;
import com.java.wikipedia.Model.Project;
import com.java.wikipedia.Repo.ProjectRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final MemberService memberService;
    private final TopicService topicService;
    private final ModelMapper mapper;


    public List<ProjectDto> getAll(){
        return projectRepo.findAll().stream().map(p -> mapper.map(p,ProjectDto.class)).collect(Collectors.toList());
    }

    public void saveProject(Project project, Principal principal){
        projectRepo.save(configProject(project,principal));
    }


    private Project configProject(Project project, Principal principal){
        project.setTopic(topicService.getByName(project.getTopic().getTopicName()));
        project.setAuthor(memberService.getByUsername(principal.getName()));
        project.setCreatedTime(new Date());
        return project;
    }
}
