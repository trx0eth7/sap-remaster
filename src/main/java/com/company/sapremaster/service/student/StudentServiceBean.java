package com.company.sapremaster.service.student;

import com.company.sapremaster.entity.Student;
import com.company.sapremaster.repository.jpa.student.StudentRepository;
import io.jmix.core.FetchPlan;
import io.jmix.core.FetchPlans;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceBean implements StudentService {

    protected final StudentRepository studentRepository;
    protected final FetchPlans fetchPlans;

    public StudentServiceBean(StudentRepository studentRepository, FetchPlans fetchPlans) {
        this.studentRepository = studentRepository;
        this.fetchPlans = fetchPlans;
    }

    @Override
    public List<Student> findByFistName(String fistName) {
        return findByFistName(fistName, fetchPlans.builder(Student.class).build());
    }

    @Override
    public List<Student> findByFistName(String fistName, FetchPlan fetchPlan) {
        return studentRepository.findAllByFirstName(fistName, fetchPlan);
    }
}