package com.codegym.c0724m1.service.impl;

import com.codegym.c0724m1.entity.Student;
import com.codegym.c0724m1.repository.StudentRepository;
import com.codegym.c0724m1.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private static StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.getAll();

        return students;
    }

    @Override
    public void save(Student s) {
        studentRepository.save(s);
    }

    @Override
    public void update(int id, Student s) {

    }

    @Override
    public void remove(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(int id) {
        List<Student> students = studentRepository.getAll();
        for (Student student: students) {
            if(student.getCode() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> students = studentRepository.getAll();
        List<Student> temp = new ArrayList<>();
        for (Student student: students) {
            if(student.getName().contains(name)) {
                temp.add(student);
            }
        }
        return temp;
    }
}
