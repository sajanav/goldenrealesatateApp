package com.goldenrealestate.app.model.test;

import com.goldenrealestate.app.model.Building;
import com.goldenrealestate.app.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {


    private SessionFactory sessionFactory;


    @Test
    public void testOperations() {
        Session session = createSessionFactory().openSession();
        create(session);
      //  readAll(session);
        updateByID(session);
      //  readAll(session);
        deleteByID(session);
      //  readAll(session);
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
        System.out.println("Updating Building...");
        Building build = (Building) session.get(Building.class,29);
        build.setBuildingname("nadarsha");
        session.beginTransaction();
        session.saveOrUpdate(build);
        session.getTransaction().commit();
    }

    private void create(Session session) {
        System.out.println("Creating Employee records...");
        Building building = new Building();
        building.setBuildingname("PrimeRose");
        building.setLocation("Dubai");

        session.save(building);
        session.getTransaction().commit();
    }


    @Before
    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    @BeforeEach
    void setUp() {
    }



    @AfterEach
    void tearDown() {
    }
}