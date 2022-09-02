package com.company.sapremaster.service.student;

import com.company.sapremaster.entity.Student;
import io.jmix.core.FetchPlan;

import java.util.List;

public interface StudentService {
    List<Student> findByFistName(String fistName);

    List<Student> findByFistName(String fistName, FetchPlan fetchPlan);
}
