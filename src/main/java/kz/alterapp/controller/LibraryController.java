package kz.alterapp.controller;

import kz.alterapp.model.Book;
import kz.alterapp.model.Customer;
import kz.alterapp.model.Library;
import kz.alterapp.service.ICustomerService;
import kz.alterapp.service.ILibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")

public class LibraryController {

    @Autowired
    ILibService service;

    @PostMapping("/create")
    public void createLibrary(@RequestBody Library library){
        service.createLib(library);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLibrary(@PathVariable("id") Integer id){

        service.deleteLib(id);
    }

    @PostMapping("/update/{id}")
    public void updateLibrary(@PathVariable("id") Integer id, @RequestBody Library library){
        service.updateLib(id, library);
    }

    @GetMapping("/availBooks/{id}")
    public List<Book> findAvailBooks(@PathVariable("id") Integer id){
        return service.findAvailableBooks(id);
    }
}
