package com.company.sapremaster.repository.mongo;

import com.company.sapremaster.SapBaseTest;
import com.company.sapremaster.entity.mongo.ExamSheetGrade;
import com.company.sapremaster.entity.mongo.ExamSheetGradeItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExamSheetGradeMongoRepositoryTest {
    
    @Autowired
    ExamSheetGradeMongoRepository examSheetGradeMongoRepository;

    @Test
    void mongoWorks() {
        // ДАНО
        var examSheetGradeItemId = 1;
        var studentId = UUID.randomUUID().toString();
        var examSheetGradeItem = new ExamSheetGradeItem(examSheetGradeItemId, studentId, 5);


        var id = 1;
        var examSheetId = UUID.randomUUID().toString();
        var examSheetGrade = new ExamSheetGrade(id, examSheetId, List.of(examSheetGradeItem));

        // КОГДА ЧТО-ТО СДЕЛАЛИ
        examSheetGradeMongoRepository.save(examSheetGrade);

        // ТОГДА ЧТО-ТО ПОЛУЧИЛИ
        var foundExamSheet = examSheetGradeMongoRepository.findById(id);

        Assertions.assertNotNull(foundExamSheet);
    }
}