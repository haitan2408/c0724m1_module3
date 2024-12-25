package com.codegym.c0724m1.repository;

import com.codegym.c0724m1.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement("select * from students");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("code");
                String name = resultSet.getString("name_student");
                String address = resultSet.getString("address");
                double point = resultSet.getDouble("point");
                String className = resultSet.getString("class_name");
                students.add(new Student(id, name, address, point, className));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public void save(Student s) {
        try {
            PreparedStatement statement = BaseRepository.getConnection()
                    .prepareStatement("insert into students(name_student, address, point, class_name) values (?,?,?,?)");
            statement.setString(1, s.getName());
            statement.setString(2, s.getAddress());
            statement.setDouble(3, s.getPoint());
            statement.setString(4, s.getClassName());
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
