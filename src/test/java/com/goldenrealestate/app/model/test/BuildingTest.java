package com.goldenrealestate.app.model.test;

import com.goldenrealestate.app.model.Building;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;


class BuildingTest {
        private SessionFactory sessionFactory;


        @Test
        public void testOperations() {
            Session session = createSessionFactory().openSession();
           // create(session);
            readAll(session);
           // updateByID(session);
           // readAll(session);
           // deleteByID(session);
           // readAll(session);
            session.close();
        }



        private void deleteByID(Session session) {
            System.out.println("Deleting building...");
            Building building = (Building) session.get(Building.class, 0);
            session.beginTransaction();
            session.delete(building);
            session.getTransaction().commit();
        }

        private void updateByID(Session session) {
            System.out.println("Updating Building...");
            Building building = (Building) session.get(Building.class,29);
            building.setBuildingname("nadarsha");
            session.beginTransaction();
            session.saveOrUpdate(building);
            session.getTransaction().commit();
        }

        private void create(Session session) {
            System.out.println("Creating Building records...");
            Building building = new Building();
            building.setBuildingname("vijayan");
            building.setLocation("Dubai");

           
            session.beginTransaction();
            session.save(building);
            session.getTransaction().commit();
        }

        private void readAll(Session session) {
            Query q = session.createQuery("select building from Building building");
            List buildingloyees = q.list();
            System.out.println("Reading Building records...");
            System.out.printf("Name", "Location");
            for (Object building : buildingloyees) {
                Building newBuild =(Building) building;
                System.out.printf(newBuild.getBuildingname(), newBuild.getLocation());
            }
        }
        @Before
        public SessionFactory createSessionFactory() {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addAnnotatedClass(com.goldenrealestate.app.model.Building.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
}