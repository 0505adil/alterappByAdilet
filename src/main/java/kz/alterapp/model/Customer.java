package kz.alterapp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
@Component
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String lastname;
    private String email;
    private Long cellnumber;
    private String address;

//    @OneToMany(mappedBy = "books")
//    private List<Book> books;
}
