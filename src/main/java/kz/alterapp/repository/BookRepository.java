package kz.alterapp.repository;

import kz.alterapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> getAllByStatusIsFalse();
    List<Book> getAllByStatusIsTrue();
}
