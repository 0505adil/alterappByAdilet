package kz.alterapp.controller;

import kz.alterapp.model.Book;
import kz.alterapp.model.Customer;
import kz.alterapp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerService service;

    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer){
        service.createCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id){
        service.deleteCustomer(id);
    }

    @PostMapping("/update/{id}")
    public void updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer){
        service.updateCustomer(id, customer);
    }

    @GetMapping("findBooks/{id}")
    public List<Book> findCustmerBook(@PathVariable("id") Integer id){
        return service.findCustomerBooks(id);
    }
}
