package by.shag.litvinov.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum ArmchairTypeEnum {

    BEANBAG_CHAIR("Кресло-мешок"),
    SEAT("Кинокресло"),
    COMFORT("Комфортное широкое кресло с подстаканником"),
    RECLINER("Комфортное кресло с личным столиком и регулировкой наклона спинки и высоты подставки для ног"),
    LOVE_SEAT("Места для двоих повышенного комфорта"),
    PREMIERE_SOFA("Двухместные мягкие диванчики с подголовниками");

    private String title;
}