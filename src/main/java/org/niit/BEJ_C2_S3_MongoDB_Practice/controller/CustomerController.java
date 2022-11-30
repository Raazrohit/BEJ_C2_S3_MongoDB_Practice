package org.niit.BEJ_C2_S3_MongoDB_Practice.controller;

import org.niit.BEJ_C2_S3_MongoDB_Practice.domain.Customer;
import org.niit.BEJ_C2_S3_MongoDB_Practice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/customer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping(value = "/customers")
    public ResponseEntity<?> getAllCustomers(){
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return responseEntity;
    }

    @DeleteMapping(value = "/customer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws ClassNotFoundException{
        ResponseEntity responseEntity = null;
        try{
            customerService.deleteCustomer(customerId);
            responseEntity = new ResponseEntity<>("SuccessFully Deleted",HttpStatus.OK);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping(value = "/customer/{productName}")
    public ResponseEntity<?> fetchCustomerByProductName(@PathVariable String productName) throws ClassNotFoundException{
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(customerService.getAllCustomersByProductName(productName),HttpStatus.OK);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        }
        return responseEntity;
    }
}
