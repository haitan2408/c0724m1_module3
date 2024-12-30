package com.codegym.c0724m1.repository;

import com.codegym.c0724m1.dto.StudentDTO;
import com.codegym.c0724m1.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {


    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement("select * from students join classrooms on students.id_class = classrooms.id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("code");
                String name = resultSet.getString("name_student");
                String address = resultSet.getString("address");
                double point = resultSet.getDouble("point");
//                Integer className = resultSet.getString("class_name");
//                students.add(new Student(id, name, address, point, className));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public List<StudentDTO> getAllDTO() {
        List<StudentDTO> students = new ArrayList<>();
        try {
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement("select * from students join classrooms on students.id_class = classrooms.id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("code");
                String name = resultSet.getString("name_student");
                String address = resultSet.getString("address");
                double point = resultSet.getDouble("point");
                String className = resultSet.getString("name_class");
                students.add(new StudentDTO(id, name, address, point, className));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public void save(Student s) {
        try {
            PreparedStatement statement = BaseRepository.getConnection()
                    .prepareStatement("insert into students(name_student, address, point, id_class) values (?,?,?,?)");
            statement.setString(1, s.getName());
            statement.setString(2, s.getAddress());
            statement.setDouble(3, s.getPoint());
            statement.setInt(4, s.getIdClass());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteById(int id) {
        try {
            PreparedStatement statement = BaseRepository.getConnection()
                    .prepareStatement("delete from students where code = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
