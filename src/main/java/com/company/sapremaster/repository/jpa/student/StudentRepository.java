package com.company.sapremaster.repository.jpa.student;

import com.company.sapremaster.entity.Student;
import com.company.sapremaster.repository.jpa.JpaJmixDataRepository;
import io.jmix.core.FetchPlan;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaJmixDataRepository<Student, UUID> {
    
    List<Student> findAllByFirstName(String fistName, FetchPlan fetchPlan);

    List<Student> findAllByActive(Boolean active, FetchPlan fetchPlan);

    List<Student> findAllByActiveTrue();

}
