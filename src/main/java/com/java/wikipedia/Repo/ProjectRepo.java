package com.java.wikipedia.Repo;

import com.java.wikipedia.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepo extends JpaRepository<Project,String> {

}
