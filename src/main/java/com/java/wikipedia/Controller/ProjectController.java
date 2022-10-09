package com.java.wikipedia.Controller;

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
    public ResponseEntity<List<Project>> all(){
        return ResponseEntity.ok(projectService.getAll());
    }
}
