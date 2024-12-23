package com.codegym.c0724m1.repository;

import com.codegym.c0724m1.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "HaTT", "QN", 9, "C0724M1"));
        students.add(new Student(3, "HaTT1", "QN", 9, "C0724M1"));
        students.add(new Student(5, "HaTT2", "QN", 9, "C0724M1"));
        students.add(new Student(6, "HaTT3", "QN", 9, "C0724M1"));
    }


    public List<Student> getAll() {
        return students;
    }

    public void save(Student s) {
        students.add(s);
    }


    public void deleteById(int id) {
        for (Student student : students) {
            if (student.getCode() == id) {
                students.remove(student);
                break;
            }
        }
    }
}
