package com.java.wikipedia.Service;

import com.java.wikipedia.Model.Project;
import com.java.wikipedia.Repo.ProjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final MemberService memberService;
    private final TopicService topicService;


    public List<Project> getAll(){
        return projectRepo.findAll();
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
