package com.example.crm.repository.customer.impl;

import com.example.crm.domain.customer.Customer;
import com.example.crm.repository.customer.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer select(Integer integer) {
        return null;
    }

    @Override
    public void insert(Customer customer) {
        jdbcTemplate.update(
                "INSERT INTO `customers` ( `first_name`, `last_name`, `phone_number`) VALUES (?, ?, ?);",
                customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber()
        );
    }

    @Override
    public void update(Integer integer, Customer customer) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Stream<Customer> selectAll() {
        return jdbcTemplate.queryForStream("SELECT * FROM `customers`;", (rs, rowNum) -> new Customer(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("phone_number")
        ));
    }
}
