package kz.alterapp.service;

import kz.alterapp.model.Book;
import kz.alterapp.model.Customer;
import kz.alterapp.model.Library;

import java.util.List;

public interface IBookService {
    void createBook(Book book);
    void deleteBook(Integer id);
    void update(Integer id, Book book);
    List<Book> listOfAvailable();
    List<Book> issueBooks();
    List<Library> findBook(Integer id);
    List<Customer> findCustomer(Integer id);
}
