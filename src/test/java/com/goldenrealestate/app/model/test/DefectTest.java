package com.goldenrealestate.app.model.test;

import com.goldenrealestate.app.model.Defect;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;


class DefectTest {



    private SessionFactory sessionFactory;


    @Test
    public void testOperations() {
        Session session = createSessionFactory().openSession();
     //   create(session);
        readAll(session);
       // updateByID(session);
      //  readAll(session);
      //  deleteByID(session);
      //  readAll(session);
        session.close();
    }



    private void deleteByID(Session session) {
        System.out.println("Deleting defects...");
        Defect def = (Defect) session.get(Defect.class, 0);
        session.beginTransaction();
        session.delete(def);
        session.getTransaction().commit();
    }

    private void updateByID(Session session) {
        System.out.println("Updating Defect...");
        Defect def = (Defect) session.get(Defect.class,29);
        def.setDefectname("light");
        session.beginTransaction();
        session.saveOrUpdate(def);
        session.getTransaction().commit();
    }

    private void create(Session session) {
        System.out.println("Creating Defect records...");
        Defect def = new Defect();
        def.setDefectname("clog");
        def.setDefectdesc("not working");


        session.beginTransaction();
        session.save(def);
        session.getTransaction().commit();
    }

    private void readAll(Session session) {
        Query q = session.createQuery("select def from Defect def");
        List defs = q.list();
        System.out.println("Reading Defect records...");
        System.out.printf( "Name", "Description");
        for (Object def : defs) {
            Defect newDef =(Defect) def;
            System.out.printf( newDef.getDefectname(), newDef.getDefectdesc());
        }
    }
    @Before
    public SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(com.goldenrealestate.app.model.Defect.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}