package kz.alterapp.service.impl;

import kz.alterapp.model.Book;
import kz.alterapp.model.Customer;
import kz.alterapp.model.Library;
import kz.alterapp.model.Order;
import kz.alterapp.repository.BookRepository;
import kz.alterapp.repository.CustomerRepository;
import kz.alterapp.repository.LibraryRepository;
import kz.alterapp.repository.OrderRepository;
import kz.alterapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, Book book) {
        Book newBook = bookRepository.findById(id).get();
        newBook.setAuthor(book.getAuthor());
        newBook.setGenre(book.getGenre());
        newBook.setName(book.getName());
        newBook.setStatus(book.getStatus());
        bookRepository.save(newBook);
    }

    @Override
    public List<Book> listOfAvailable() {
        return bookRepository.getAllByStatusIsFalse();
    }

    @Override
    public List<Book> issueBooks() {
        return bookRepository.getAllByStatusIsTrue();
    }

    @Override
    public List<Library> findBook(Integer id) {
        Book fBook = bookRepository.findById(id).get();
        ArrayList<Library> libraries = new ArrayList<>();
        for (int i = 0; i < libraryRepository.findAll().size(); i++) {
            if(id == libraryRepository.findAllBy().get(i).getBook_id()){
                libraries.add(libraryRepository.findAllBy().get(i));
            }
        }
        if(fBook == null){
            System.out.println("There is no such book");
        }
        return libraries;
    }

    @Override
    public List<Customer> findCustomer(Integer id) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Integer> customerId = new ArrayList<>();
        for (int i = 0; i < orderRepository.findByBook_id(id).size(); i++) {
            customerId.add(orderRepository.findByBook_id(id).get(i).getCustomer_id());
        }
        for (int i = 0; i < customerRepository.findAll().size(); i++) {
            if(customerId.contains(customerRepository.findAll().get(i).getId())){
                customers.add(customerRepository.findAll().get(i));
            }
        }
        return customers;
    }
}
