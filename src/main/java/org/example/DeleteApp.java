package org.example;

import org.example.domain.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class DeleteApp {
    public static void main(String[] args) {
        var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        final Session session = factory.getCurrentSession();

        final Transaction transaction = session.beginTransaction();
        /** Transaction started */

        final Student student = session.get(Student.class, 3);
        session.remove(student);

        transaction.commit();
        /** Transaction stoped */


    }
}
