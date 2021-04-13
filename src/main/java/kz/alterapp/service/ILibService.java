package kz.alterapp.service;

import kz.alterapp.model.Book;
import kz.alterapp.model.Library;

import java.util.List;

public interface ILibService {
    void createLib(Library library);
    void deleteLib(Integer id);
    void updateLib(Integer id, Library library);
    List<Book> findAvailableBooks(Integer id);
}
