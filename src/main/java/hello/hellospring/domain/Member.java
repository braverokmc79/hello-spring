package hello.hellospring.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.ToString;

@Data
@ToString
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;




}
