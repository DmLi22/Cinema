package by.shag.litvinov.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cinema")
@Data
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "number_of_hall", nullable = false)
    private Integer numberOfHall;

    @Column(nullable = false)
    private Boolean parking;

    @Column(nullable = false)
    private Boolean cafe;
}
