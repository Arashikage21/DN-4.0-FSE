package com.cognizant.jpa_demo;

import com.cognizant.jpa_demo.dao.EmployeeDao;
import com.cognizant.jpa_demo.model.Employee;

public class HibernateApp {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Integer id = dao.addEmployee(new Employee("Alice"));
        System.out.println("Hibernate saved Employee with ID: " + id);
    }
}
