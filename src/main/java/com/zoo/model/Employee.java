package com.zoo.model;

public class Employee {
    private int id;
    private String fullName;
    private String position;
    private double salary;
    private String phone;

    public Employee(String fullName, String position, double salary, String phone) {
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.phone = phone;
    }

    public Employee(int id, String fullName, String position, double salary, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.phone = phone;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
