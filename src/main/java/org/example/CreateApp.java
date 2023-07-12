package org.example;

import org.example.domain.Student;
import org.example.domain.StudentDetail;
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
        // start tx

        final Student student = new Student("Reza3", "Reza", "ali@protonmail.com");
        final StudentDetail detail = new StudentDetail("091222222", "Mohammad3");

        student.setDetail(detail);

        session.persist(detail);
        session.persist(student);



        // stop tx
        transaction.commit();




    }
}
