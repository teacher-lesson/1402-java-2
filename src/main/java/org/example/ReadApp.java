package org.example;

import org.example.domain.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class ReadApp {
    public static void main(String[] args) {
        try (
                var factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory()
        ) {
            try (final Session session = factory.getCurrentSession()) {

                final Transaction transaction = session.beginTransaction();

                final Teacher teacher = session.createQuery("from Teacher t join fetch t.courses c where t.id = 2", Teacher.class).getSingleResult();

                System.out.println(teacher);
                transaction.commit();

                System.out.println("After teacher call");
                System.out.println(teacher.getCourses());
            }
        }
    }
}
