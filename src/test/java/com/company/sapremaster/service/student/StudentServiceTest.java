package com.company.sapremaster.service.student;

import com.company.sapremaster.SapBaseTest;
import com.company.sapremaster.entity.Student;
import io.jmix.core.FetchPlans;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class StudentServiceTest extends SapBaseTest {

    @Autowired
    StudentService studentService;
    @Autowired
    FetchPlans fetchPlans;

    @Test
    void findByFistName() {
        // ДАНО
        var student = dataManager.create(Student.class);

        var firstName = "Петя";
        var lastName = "Васильев";

        student.setFirstName(firstName);
        student.setLastName(lastName);

        entitiesToRemove.add(dataManager.save(student));

        // ЧТО-ТО ДЕЛАЕМ
        var students = studentService.findByFistName(firstName);


        // ЧТО-ТО ПРОВЕРЯЕМ
        Assertions.assertFalse(students.isEmpty());
        Assertions.assertEquals(1, students.size());

        Assertions.assertEquals("Петя",
                students.stream()
                        .findFirst()
                        .map(Student::getFirstName)
                        .orElse("Unknown"));
    }

    @Test
    void findByFistNameAndFetchPlan() {
        // ДАНО
        var student = dataManager.create(Student.class);

        var firstName = "Петя";
        var lastName = "Васильев";

        student.setFirstName(firstName);
        student.setLastName(lastName);

        entitiesToRemove.add(dataManager.save(student));

        // ЧТО-ТО ДЕЛАЕМ
        var students = studentService.findByFistName(firstName,
                fetchPlans.builder(Student.class)
                        .add("firstName").build());

        // ЧТО-ТО ПРОВЕРЯЕМ
        Assertions.assertFalse(students.isEmpty());
        Assertions.assertEquals(1, students.size());

//        Assertions.assertThrows(Exception.class, () -> {
//            var student1 = students.get(0);
//            var lastName1 = student1.getLastName();
//        });

        Assertions.assertEquals("Петя",
                students.stream()
                        .findFirst()
                        .map(Student::getFirstName)
                        .orElse("Unknown"));
    }
}