package org.example;

import org.example.domain.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 */
public class ReadApp {
    public static void main(String[] args) {
        var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        final Session session = factory.getCurrentSession();

        final Transaction transaction = session.beginTransaction();

        final List<Student> fromStudent = (List<Student>) session.createQuery(
                "from Student a where a.email like '%@protonmail.com'"
                )
                .getResultList();

        System.out.println(fromStudent);


        transaction.commit();


    }
}
