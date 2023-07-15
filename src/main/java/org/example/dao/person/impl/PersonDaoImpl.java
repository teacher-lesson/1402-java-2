package org.example.dao.person.impl;

import org.example.dao.HibernateHelper;
import org.example.domain.person.Person;

public class PersonDaoImpl implements PersonDao {

    private HibernateHelper helper;

    public PersonDaoImpl(HibernateHelper helper) {
        this.helper = helper;
    }

    public void insert(Person person) {
        var session = helper.getSession();
        var transaction = session.beginTransaction();

        session.persist(person);

        transaction.commit();
    }
}
