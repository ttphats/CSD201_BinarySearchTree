/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author SE150968 - Thai Thanh Phat
 */
public class Employee {
    String code = "";
    String name = "";
    int salary = 0;

    public Employee() {
    }
    public Employee(String c, String n, int s) {
        code = c;
        name = n;
        salary = s;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "code=" + code + ", name=" + name + ", salary=" + salary + '}';
    }
    
    
    
}

