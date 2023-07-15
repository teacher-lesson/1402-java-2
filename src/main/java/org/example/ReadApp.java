package org.example;

import org.example.domain.Student;
import org.example.domain.StudentDetail;
import org.example.domain.Teacher;
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

        final Teacher teacher = session.get(Teacher.class, 2);

        System.out.println(teacher);

        transaction.commit();

        System.out.println("After teacher call");

        System.out.println(teacher.getCourses());


    }
}
