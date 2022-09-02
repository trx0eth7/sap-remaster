package com.company.sapremaster.entity.mongo;

import org.springframework.data.annotation.Id;

public class ExamSheetGradeItem {

    @Id
    private Integer id;
    private String studentId;
    private Integer value;

    public ExamSheetGradeItem(Integer id, String studentId, Integer value) {
        this.id = id;
        this.studentId = studentId;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
