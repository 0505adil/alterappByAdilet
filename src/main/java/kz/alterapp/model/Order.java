package kz.alterapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
@Component

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer book_id;
    private Integer library_id;
    private Integer customer_id;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @Getter(AccessLevel.NONE)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "library_id", insertable = false, updatable = false)
    @Getter(AccessLevel.NONE)
    private Library library;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    @Getter(AccessLevel.NONE)
    private Customer customer;

}
