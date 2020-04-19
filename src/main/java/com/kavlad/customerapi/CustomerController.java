package com.kavlad.customerapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CustomerController {

    private HashMap<Integer, Customer> Customers = new HashMap<Integer, Customer>() {{
        put(1, new Customer(
                "firstName1",
                "lastName1",
                "+973501111111",
                "customer1@kavlad.com",
                new Address(
                        "type_A",
                        "Sharjah",
                        "UAE",
                        "Addres Line 1"
                )
        ));
        put(2, new Customer(
                "firstName2",
                "lastName2",
                "+971502222222",
                "customer2@kavlad.com",
                new Address(
                        "type_A",
                        "Dubai",
                        "UAE",
                        "Addres Line 2"
                )
        ));
    }};

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public HashMap<Integer, Customer> getCustomers() {
        return this.Customers;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("id") int id) {
        return this.Customers.get(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public HttpStatus createCustomers(@RequestBody Customer payload) {
        this.Customers.put(this.Customers.size() + 1, payload);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/customer/{id}/address", method = RequestMethod.POST)
    public HttpStatus createAddress(@PathVariable("id") int id, @RequestBody Address payload) {
        this.Customers.get(id).setAddress(payload);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/customer/{id}/address", method = RequestMethod.DELETE)
    public HttpStatus deleteAddress(@PathVariable("id") int id) {
        this.Customers.get(id).setAddress(null);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
    public HashMap<Integer, Customer> getCustomersByCity(@PathVariable("name") String city) {
        HashMap<Integer, Customer> response = new HashMap<Integer, Customer>();
        this.Customers.forEach((key, val) -> {
            if (val.getAddress().getCity().equals(city)) {
                response.put(key, val);
            }
        });
        return response;
    }

    @RequestMapping(value = "/phone/{prefix}", method = RequestMethod.GET)
    public HashMap<Integer, Customer> getCustomersByPhone(@PathVariable("prefix") String prefix) {
        HashMap<Integer, Customer> response = new HashMap<Integer, Customer>();
        this.Customers.forEach((key, val) -> {
            if (val.getPhoneNumber().startsWith(prefix)) {
                response.put(key, val);
            }
        });
        return response;
    }

}