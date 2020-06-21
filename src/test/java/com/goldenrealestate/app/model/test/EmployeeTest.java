package com.goldenrealestate.app.model.test;

import com.goldenrealestate.app.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
@EnableAutoConfiguration
@EntityScan(basePackageClasses=Employee.class)
class EmployeeTest {


    private SessionFactory sessionFactory;


    @Test
    public void testOperations() {
        Session session = createSessionFactory().openSession();
        create(session);
        readAll(session);
        updateByID(session);
        readAll(session);
        deleteByID(session);
        readAll(session);
        session.close();
    }



    private void deleteByID(Session session) {
        System.out.println("Deleting employee...");
        Employee emp = (Employee) session.get(Employee.class, 0);
        session.beginTransaction();
        session.delete(emp);
        session.getTransaction().commit();
    }

    private void updateByID(Session session) {
        System.out.println("Updating Employee...");
        Employee emp = (Employee) session.get(Employee.class,29);
        emp.setEmployeeName("nadarsha");
        session.beginTransaction();
        session.saveOrUpdate(emp);
        session.getTransaction().commit();
    }

    private void create(Session session) {
        System.out.println("Creating Employee records...");
        Employee emp = new Employee();
        emp.setEmployeeName("vijayan");
        emp.setContactNo("0556649326");
        emp.setEmailID("vsajana@gmail.com");

        Employee secondEmp = new Employee();
        secondEmp.setEmployeeName("nadarsha");
        secondEmp.setContactNo("0556649325");
        secondEmp.setEmailID("mshas7@gmail.com");

        session.beginTransaction();
        session.save(emp);
        session.save(secondEmp);
        session.getTransaction().commit();
    }

    private void readAll(Session session) {
        Query q = session.createQuery("select emp from Employee emp");
        List employees = q.list();
        System.out.println("Reading Employee records...");
        System.out.printf("Name", "Contact Number");
        for (Object emp : employees) {
            Employee newEmp =(Employee) emp;
            System.out.printf(newEmp.getEmployeeName(), newEmp.getContactNo());
        }
    }
    @Before
    public SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}