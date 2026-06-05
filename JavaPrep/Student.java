package com.dsa.JavaPrep;

import java.util.Objects;

public class Student {
    private int id;
    private String name;

    Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student Info :: Id : " + id + " Name : " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
