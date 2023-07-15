package org.example;

import org.example.domain.Course;
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
public class CreateApp {
    public static void main(String[] args) {
        var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        final Session session = factory.getCurrentSession();

        final Transaction transaction = session.beginTransaction();
        // start tx

        final Teacher teacher = new Teacher("Ali", "Hassani", "ex@gmail.com");

        final Course java = new Course("Java", teacher);
        final Course php = new Course("Php", teacher);
        final Course math = new Course("Math", teacher);

        teacher.setCourses(List.of(java, php, math));

        session.persist(teacher);

        // stop tx
        transaction.commit();




    }
}
