package kz.alterapp.service.impl;

import kz.alterapp.model.Book;
import kz.alterapp.model.Library;
import kz.alterapp.model.Order;
import kz.alterapp.repository.BookRepository;
import kz.alterapp.repository.LibraryRepository;
import kz.alterapp.repository.OrderRepository;
import kz.alterapp.service.ILibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service

public class LibraryServiceImpl implements ILibService {

    @Autowired
    LibraryRepository repository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void createLib(Library library) {
        repository.save(library);
    }

    @Override
    public void deleteLib(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateLib(Integer id, Library library) {
        Library newLib = repository.findById(id).get();
        newLib.setBook_id(newLib.getBook_id());
        newLib.setName(newLib.getName());
        repository.save(newLib);
    }

    @Override
    public List<Book> findAvailableBooks(Integer id) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Integer> bookId = new ArrayList<>();
        for (int i = 0; i < orderRepository.findByLibrary_id(id).size(); i++) {
            bookId.add(orderRepository.findByLibrary_id(id).get(i).getBook_id());
        }
        for (int i = 0; i < repository.findAll().size(); i++) {
            if(bookId.contains(repository.findAll().get(i).getBook_id())){
                bookId.remove(repository.findAll().get(i).getBook_id());
            }
        }
        for (int i = 0; i < bookRepository.findAll().size(); i++) {
            if(bookId.contains(bookRepository.findAll().get(i).getId())){
                books.add(bookRepository.findAll().get(i));
            }
        }
        return books;
    }
}
