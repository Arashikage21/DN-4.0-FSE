package com.cognizant.jpa_demo.dao;


import com.cognizant.jpa_demo.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {
    private SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();

    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }
}

