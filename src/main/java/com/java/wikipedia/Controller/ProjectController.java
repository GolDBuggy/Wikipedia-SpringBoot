package com.java.wikipedia.Controller;

import com.java.wikipedia.Dto.ProjectDto;
import com.java.wikipedia.Dto.UpdateRequest;
import com.java.wikipedia.Model.Project;
import com.java.wikipedia.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/save")
    public ResponseEntity<Project> save(@RequestBody Project project, Principal principal){
        projectService.saveProject(project,principal);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDto>> all(){
        return ResponseEntity.ok(projectService.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id,@RequestBody UpdateRequest updateRequest,Principal principal){
        projectService.updateProject(id,updateRequest,principal);
        return ResponseEntity.ok(updateRequest.getNewText());
    }
}
