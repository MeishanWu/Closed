package com.example.chuan.closed;

public class Course {

    private int number;
    private String subject;
    private String status;
    private int crn;

    public Course(int number, String subject, String status, int crn) {
        this.number = number;
        this.subject = subject;
        this.status = status;
        this.crn = crn;
    }

    public Course(){}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }




}
