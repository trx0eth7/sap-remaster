package com.company.sapremaster.repository.mongo;

import com.company.sapremaster.entity.mongo.ExamSheetGrade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamSheetGradeMongoRepository extends MongoRepository<ExamSheetGrade, Integer> {
}
