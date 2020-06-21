package com.goldenrealestate.app.model.test;

import com.goldenrealestate.app.model.ProgressBar;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProgressBarTest {

    private SessionFactory sessionFactory;


    @Test
    public void testOperations() {
        Session session = createSessionFactory().openSession();
        readAll(session);
        session.close();
    }


    private void readAll(Session session) {
        Query q = session.createQuery("select progressBar from ProgressBar progressBar");
        List progressBars = q.list();
        System.out.println("Reading ProgressBar records...");
        System.out.printf("BuildingName", "Employee");
        for (Object progressBar : progressBars) {
            ProgressBar newBar =(ProgressBar) progressBar;
            System.out.printf( newBar.getBuilding().getBuildingname(), newBar.getEmployee().getEmployeeName());
        }
    }
    @Before
    public SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();

        configuration.addAnnotatedClass(com.goldenrealestate.app.model.ProgressBar.class);
        configuration.addAnnotatedClass(com.goldenrealestate.app.model.Employee.class);
        configuration.addAnnotatedClass(com.goldenrealestate.app.model.Defect.class);
        configuration.addAnnotatedClass(com.goldenrealestate.app.model.Building.class);
        configuration.addAnnotatedClass(com.goldenrealestate.app.model.Status.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}
