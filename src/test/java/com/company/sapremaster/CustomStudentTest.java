package com.company.sapremaster;

import com.company.sapremaster.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomStudentTest extends SapBaseTest {

    @Test
    void studentTest() {
        // given
        var student = dataManager.create(Student.class);

        student.setFirstName("Вася123");
        student.setLastName("Сидоров");


        entitiesToRemove.add(dataManager.save(student));

        // when
        var students = dataManager.load(Student.class)
                .query("select e from sap_Student e where e.firstName = :firstName")
                .parameter("firstName", "Вася123")
                .list();

        // then
        Assertions.assertFalse(students.isEmpty());
        Assertions.assertEquals(1, students.size());

        Assertions.assertEquals("Вася123",
                students.stream()
                        .findFirst()
                        .map(Student::getFirstName)
                        .orElse("Unknown"));
    }
}
