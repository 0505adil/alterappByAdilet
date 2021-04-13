package kz.alterapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "books")
@Component

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String author;
    private Boolean status;
    private String genre;
//    private Integer user_id;
//    private Integer library_id;

//    @ManyToOne
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    @Getter(AccessLevel.NONE)
//    private Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "library_id", insertable = false, updatable = false)
//    @Getter(AccessLevel.NONE)
//    private Library library;
}
