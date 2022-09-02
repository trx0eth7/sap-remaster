package com.company.sapremaster.repository.jpa.student;

import com.company.sapremaster.SapBaseTest;
import com.company.sapremaster.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Alexander Vasiliev
 */
class StudentCustomRepositoryTest extends SapBaseTest {

    @Autowired
    StudentCustomRepository studentCustomRepository;

    @Autowired
    StudentRepository studentRepository;

    @Test
    void deleteInactive() {
        // ДАНО
        var student1 = dataManager.create(Student.class);
        var student2 = dataManager.create(Student.class);

        student1.setFirstName("ВасяS");
        student1.setLastName("Сидоров");
        student1.setActive(true);

        student2.setFirstName("Маша");
        student2.setLastName("Федорова");
        student2.setActive(false);

        dataManager.save(student1, student2);


        // Для очищения записей
        entitiesToRemove.add(student1);

        // КОГДА ЧТО-ТО СДЕЛАЛИ
        studentCustomRepository.deleteInactive2();

        // ТОГДА ЧТО-ТО ПОЛУЧИЛИ
        var activeStudents = studentRepository.findAllByActiveTrue();

        Assertions.assertEquals(1, activeStudents.size());
        Assertions.assertTrue(activeStudents.contains(student1));

    }
}