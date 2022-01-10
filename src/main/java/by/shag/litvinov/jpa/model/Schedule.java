package by.shag.litvinov.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "schedule")
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "movie_id")
    //private Movie movie;      //раскоментать
    private Integer movieId;    //закоментать

    @Column(name = "start_date_time")
    private Instant startDateTime;

    @Column(name = "end_date_time")
    private Instant endDateTime;

//    @OneToMany(mappedBy = "schedule")
//    Set<HallsSchedules> hallsSchedules;
}