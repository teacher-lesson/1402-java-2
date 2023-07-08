package com.example.crm.service.customer.impl;

import com.example.crm.domain.customer.Customer;
import com.example.crm.repository.customer.CustomerDao;
import com.example.crm.service.customer.CustomerService;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void create(Customer customer) {
        customerDao.insert(customer);
    }

    @Override
    public Customer read(Integer integer) {
        return null;
    }

    @Override
    public void modify(Integer integer, Customer customer) {

    }

    @Override
    public void remove(Integer integer) {

    }

    @Override
    public Stream<Customer> readAll() {
        return customerDao.selectAll();
    }
}
