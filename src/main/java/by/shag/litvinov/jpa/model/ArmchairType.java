package by.shag.litvinov.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "armchair_type")
@Data
public class ArmchairType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "armchair_type", nullable = false)
    private ArmchairTypeEnum armchairType;
}