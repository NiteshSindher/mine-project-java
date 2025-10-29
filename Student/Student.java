package com.example.studentmgmt.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;
    private double fees;

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public double getFees() { return fees; }
    public void setFees(double fees) { this.fees = fees; }

    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name + ", course=" + course + ", fees=" + fees + "]";
    }
}
