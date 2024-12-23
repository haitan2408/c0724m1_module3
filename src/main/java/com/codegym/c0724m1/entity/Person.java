package com.codegym.c0724m1.entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class Person {
    private long code;
    private String name;
    private String address;

    public Person() {
    }

    public Person(long code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return code == person.code && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + code +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
