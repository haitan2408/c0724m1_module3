package com.codegym.c0724m1.entity;

public class Student extends Person implements Comparable<Student>{
    private double point;
    private Integer idClass;

    public Student() {
    }


    public Student(int id, String name, String address, double point, Integer className) {
        super(id, name, address);
        this.point = point;
        this.idClass = className;
    }

    public Student(String name, String address, double point, Integer className) {
        super(name, address);
        this.point = point;
        this.idClass = className;
    }


    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    @Override
    public String toString() {
        return super.toString()+"Student{" +
                "point=" + point +
                ", className='" + idClass + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.getCode() > o.getCode()) {
            return 1;
        } else if(this.getCode() == o.getCode()) {
            return this.getName().compareTo(o.getName());
        }
        return -1;
    }
}
