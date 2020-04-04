package com.example.demo.dao;


import com.example.demo.entities.JobRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JobRequestRepository extends JpaRepository<JobRequest, Long> {
}
