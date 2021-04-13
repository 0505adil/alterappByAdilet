package kz.alterapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "libraries")
@Component

public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer book_id;

//    @OneToMany
//    @JoinColumn(name = "book_id", insertable = false, updatable = false)
//    @Getter(AccessLevel.NONE)
//    private Library library;


//    @OneToMany(mappedBy = "library")
//    private List<Book> books;


}
