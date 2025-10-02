package com.dev.laedson.crmColumna.service;

import com.dev.laedson.crmColumna.dto.CreateProjectDto;
import com.dev.laedson.crmColumna.dto.ProjectIdDto;
import com.dev.laedson.crmColumna.dto.UpdateProjectDto;
import com.dev.laedson.crmColumna.dto.UserIdDto;
import com.dev.laedson.crmColumna.model.Project;
import com.dev.laedson.crmColumna.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(CreateProjectDto createProjectDto) {

        var project = new Project(
                createProjectDto.name(),
                createProjectDto.description(),
                createProjectDto.startDate(),
                createProjectDto.endDate()
        );

        projectRepository.save(project);
        return project;
    }

    public Project getProjectById(ProjectIdDto projectIdDto) {
        var project = projectRepository.findById(projectIdDto.projectId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        return project;
    }

    public List<Project> getAllprojects(UserIdDto userIdDto) {

        return projectRepository.findByUserId(userIdDto.userId());
    }

    public void updateProject(UpdateProjectDto updateProjectDto) {
        Project project = projectRepository.findById(updateProjectDto.projectId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!updateProjectDto.nome().equals(null)) project.setProjectName(updateProjectDto.nome());
        if (!updateProjectDto.descricao().equals(null)) project.setProjectDescription(updateProjectDto.descricao());

        projectRepository.save(project);

    }

    public void deleteProject(ProjectIdDto projectIdDto) {
        projectRepository.deleteById(projectIdDto.projectId());
    }
}
