package by.shag.litvinov.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
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
    private Integer movie;

    @Column(name = "show_date")
    private Instant showDate;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @OneToMany(mappedBy = "schedule")
    Set<HallsSchedules> hallsSchedules;
}