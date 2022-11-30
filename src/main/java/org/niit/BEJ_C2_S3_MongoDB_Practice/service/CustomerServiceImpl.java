package org.niit.BEJ_C2_S3_MongoDB_Practice.service;

import org.niit.BEJ_C2_S3_MongoDB_Practice.domain.Customer;
import org.niit.BEJ_C2_S3_MongoDB_Practice.exception.CustomerNotFoundException;
import org.niit.BEJ_C2_S3_MongoDB_Practice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int customerId) throws ClassNotFoundException {
        boolean flag = false;
        if(customerRepository.findById(customerId).isEmpty()){
            throw new ClassNotFoundException();
        }
        else {
            customerRepository.deleteById(customerId);
            flag=true;
        }
        return flag;
    }

    @Override
    public List<Customer> getAllCustomersByProductName(String productName) throws ClassNotFoundException {
        return null;
    }
}
