package com.codegym.c0724m1.dto;

public class StudentDTO {
    private long code;
    private String name;
    private String address;
    private double point;
    private String className;

    public StudentDTO() {
    }

    public StudentDTO(long code, String name, String address, double point, String className) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.point = point;
        this.className = className;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
