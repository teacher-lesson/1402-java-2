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
//        final Course java = session.get(Course.class, 1);

        final Teacher teacher = new Teacher("Hassan2", "Alavi2", "ex2@gmail.com");

        teacher.addCourse(new Course("Java"));
        teacher.addCourse(new Course("Physics"));
        teacher.addCourse(new Course("English"));

//        teacher.getCourses().add(java);

        session.persist(teacher);

        // stop tx
        transaction.commit();




    }
}
