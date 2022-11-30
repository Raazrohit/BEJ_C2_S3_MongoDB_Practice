package org.niit.BEJ_C2_S3_MongoDB_Practice.service;

import org.niit.BEJ_C2_S3_MongoDB_Practice.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers() throws Exception;
    boolean deleteCustomer(int customerId) throws ClassNotFoundException;
    List<Customer> getAllCustomersByProductName(String productName) throws ClassNotFoundException;
}
