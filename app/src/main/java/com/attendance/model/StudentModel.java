package com.attendance.model;

public class StudentModel {

    private String studentName;

    private boolean present;

    private boolean absent;

    private boolean late;

    public StudentModel(String studentName, boolean present, boolean absent, boolean late) {
        this.studentName = studentName;
        this.present = present;
        this.absent = absent;
        this.late = late;
    }

    public String getStudentName() {
        return studentName;
    }

    public boolean isPresent() {
        return present;
    }

    public boolean isAbsent() {
        return absent;
    }

    public boolean isLate() {
        return late;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public void setAbsent(boolean absent) {
        this.absent = absent;
    }

    public void setLate(boolean late) {
        this.late = late;
    }
}
