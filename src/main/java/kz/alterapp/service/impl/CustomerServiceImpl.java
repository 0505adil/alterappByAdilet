package kz.alterapp.service.impl;

import kz.alterapp.model.Book;
import kz.alterapp.model.Customer;
import kz.alterapp.repository.BookRepository;
import kz.alterapp.repository.CustomerRepository;
import kz.alterapp.repository.OrderRepository;
import kz.alterapp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(Integer id, Customer customer) {
        Customer newCustomer = customerRepository.findById(id).get();
        newCustomer.setAddress(newCustomer.getAddress());
        newCustomer.setCellnumber(newCustomer.getCellnumber());
        newCustomer.setEmail(newCustomer.getEmail());
        newCustomer.setLastname(newCustomer.getLastname());
        newCustomer.setName(newCustomer.getName());
        customerRepository.save(newCustomer);
    }

    @Override
    public List<Book> findCustomerBooks(Integer id) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Integer> bookId = new ArrayList<>();
        for (int i = 0; i < orderRepository.findByCustomer_id(id).size(); i++) {
            bookId.add(orderRepository.findByCustomer_id(id).get(i).getBook_id());
        }
        for (int i = 0; i < bookRepository.findAll().size(); i++) {
            if(bookId.contains(bookRepository.findAll().get(i).getId())){
                books.add(bookRepository.findAll().get(i));
            }
        }
        return books;
    }
}
