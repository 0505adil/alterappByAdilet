package kz.alterapp.service;

import kz.alterapp.model.Book;
import kz.alterapp.model.Customer;

import java.util.List;

public interface ICustomerService {
    void createCustomer(Customer customer);
    void deleteCustomer(Integer id);
    void updateCustomer(Integer id, Customer customer);
    List<Book> findCustomerBooks(Integer id);

}
