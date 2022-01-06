package by.shag.litvinov.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hall")
@Data
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @Column(name = "three_D", nullable = false)
    private Boolean three3D;

    @Column(name = "dolby_atmos_sound", nullable = false)
    private Boolean dolbyAtmosSound;

    @Column(name = "number_of_seats", nullable = false)
    private Integer numberOfSeats;

    @Column(name = "number_of_person", nullable = false)
    private Integer numberOfPerson;

    @Column(nullable = false)
    private Boolean deluxe;

    @OneToMany(mappedBy = "hall")
    Set<HallsSchedules> hallsSchedules;
}
