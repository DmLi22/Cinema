package by.shag.litvinov.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "halls_schedules")
@Data
public class HallsSchedules {

    @EmbeddedId
    private HallsSchedulesKey id;   // ? baeldung.com

    @ManyToOne
    @MapsId("hallId")
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @ManyToOne
    @MapsId("scheduleId")
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
}
