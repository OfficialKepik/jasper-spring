package org.itstep.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers", produces = "application/json")
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping(value = "/customers/sort", produces = "application/json")
    public List<Customer> getCustomersSort(@RequestParam(name = "property") String property) {
        return customerService.orderBy(property);
    }
}
