package com.codegym.c0724m1.service;

import com.codegym.c0724m1.dto.StudentDTO;
import com.codegym.c0724m1.entity.Student;

import java.util.List;

public interface IStudentService extends IService<Student> {

        List<StudentDTO> getAllDTO();
}
