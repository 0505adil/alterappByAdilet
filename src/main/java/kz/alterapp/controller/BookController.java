package kz.alterapp.controller;

import kz.alterapp.model.Book;
import kz.alterapp.model.Customer;
import kz.alterapp.model.Library;
import kz.alterapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService service;

    @PostMapping("/create")
    public void createBook(@RequestBody Book book){
        service.createBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") Integer id){
        service.deleteBook(id);
    }

    @PostMapping("/update/{id}")
    public void updateBook(@PathVariable("id") Integer id, @RequestBody Book book){
        service.update(id, book);
    }

    @GetMapping("/available/books")
    public List<Book> getAvailableBook(){
        return service.listOfAvailable();
    }

    @GetMapping("/issue/books")
    public List<Book> getIssueBook(){
        return service.issueBooks();
    }

    @GetMapping("/findBook/{id}")
    public List<Library> findBooks(@PathVariable("id") Integer id){
        return service.findBook(id);
    }

    @GetMapping("/findCustomer/{id}")
    public List<Customer> findCustomer(@PathVariable("id") Integer id){
        return service.findCustomer(id);
    }
}
