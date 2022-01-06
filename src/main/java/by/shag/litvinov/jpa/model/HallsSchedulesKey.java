package by.shag.litvinov.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class HallsSchedulesKey implements Serializable {

    @Column(name = "hall_id", nullable = false)
    private Integer hallId;

    @Column(name = "schedule_id", nullable = false)
    private Integer scheduleId;
}
