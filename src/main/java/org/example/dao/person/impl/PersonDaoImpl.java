package org.example.dao.person.impl;

import org.example.dao.BaseDaoImpl;
import org.example.dao.HibernateHelper;
import org.example.dao.person.PersonDao;
import org.example.domain.person.Person;

public class PersonDaoImpl extends BaseDaoImpl<Person, Integer> implements PersonDao {

    private final HibernateHelper helper;

    public PersonDaoImpl(HibernateHelper helper) {
        this.helper = helper;
    }

    @Override
    protected HibernateHelper getHelper() {
        return helper;
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }
}
