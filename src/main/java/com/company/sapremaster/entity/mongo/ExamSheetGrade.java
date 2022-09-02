package com.company.sapremaster.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("grades")
public class ExamSheetGrade {

    @Id
    private Integer id;
    private String examSheetId;
    private List<ExamSheetGradeItem> items;

    public ExamSheetGrade(Integer id, String examSheetId, List<ExamSheetGradeItem> items) {
        this.id = id;
        this.examSheetId = examSheetId;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamSheetId() {
        return examSheetId;
    }

    public void setExamSheetId(String examSheetId) {
        this.examSheetId = examSheetId;
    }

    public List<ExamSheetGradeItem> getItems() {
        return items;
    }

    public void setItems(List<ExamSheetGradeItem> items) {
        this.items = items;
    }
}
