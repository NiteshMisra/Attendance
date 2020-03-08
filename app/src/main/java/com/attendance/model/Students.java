package com.attendance.model;

public class Students {

    private Integer studentId;

    private String status;

    public Students(Integer studentId, String status) {
        this.studentId = studentId;
        this.status = status;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStatus() {
        return status;
    }


}
