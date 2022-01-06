package by.shag.litvinov.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "place")
@Data
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "armchair_type_id", nullable = false)
    @Enumerated(EnumType.STRING)
    private ArmchairType armchairType;

    @Column(name = "row")
    private Integer row;

    @Column(name = "place")
    private Integer place;
}
