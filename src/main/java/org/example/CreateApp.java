package org.example;

import org.example.domain.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class CreateApp {
    public static void main(String[] args) {
        var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        final Session session = factory.getCurrentSession();

        final Transaction transaction = session.beginTransaction();

        final Student student = new Student("Reza", "Reza", "ali@protonmail.com");
        session.persist(student);
//        session.save()

        transaction.commit();


    }
}
