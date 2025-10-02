package com.dev.laedson.crmColumna.controller;

import com.dev.laedson.crmColumna.dto.CreateProjectDto;
import com.dev.laedson.crmColumna.dto.ProjectIdDto;
import com.dev.laedson.crmColumna.dto.UpdateProjectDto;
import com.dev.laedson.crmColumna.dto.UserIdDto;
import com.dev.laedson.crmColumna.model.Project;
import com.dev.laedson.crmColumna.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody CreateProjectDto createProjectDto){
        var project = projectService.createProject(createProjectDto);

        return ResponseEntity.ok().body(project);

    }

    @GetMapping
    public ResponseEntity<Project> getProjectById(@RequestBody ProjectIdDto projectId){
        var project = projectService.getProjectById(projectId);

        return ResponseEntity.ok().body(project);
    }

    @GetMapping("/user/projects")
    public ResponseEntity<List<Project>> getAllProject(@RequestBody UserIdDto userId){
        List<Project> projects = projectService.getAllprojects(userId);

        return ResponseEntity.ok().body(projects);
    }

    @PutMapping
    public ResponseEntity<Void> putProject(@RequestBody UpdateProjectDto updateProjectDto) {
        projectService.updateProject(updateProjectDto);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProject(@RequestBody ProjectIdDto projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }
}
