package org.example;

import org.example.domain.Student;
import org.example.domain.StudentDetail;
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

        final StudentDetail detail = session.get(StudentDetail.class, 1);

        final Student student = detail.getStudent();

        System.out.println(student);

        transaction.commit();


    }
}
