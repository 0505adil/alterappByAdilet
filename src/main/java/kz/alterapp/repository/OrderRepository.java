package kz.alterapp.repository;

import kz.alterapp.model.Book;
import kz.alterapp.model.Customer;
import kz.alterapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer_id(Integer id);
    List<Order> findByBook_id(Integer id);
    List<Order> findByLibrary_id(Integer id);
}
