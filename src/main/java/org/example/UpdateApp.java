package org.example;

import org.example.domain.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class UpdateApp {
    public static void main(String[] args) {
        var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        final Session session = factory.getCurrentSession();

        final Transaction transaction = session.beginTransaction();
        /** Transaction started */

        final Student student = session.get(Student.class, 2);

        student.setLastName("Reza");

        session.merge(student); // optional

        transaction.commit();
        /** Transaction stoped */


    }
}
