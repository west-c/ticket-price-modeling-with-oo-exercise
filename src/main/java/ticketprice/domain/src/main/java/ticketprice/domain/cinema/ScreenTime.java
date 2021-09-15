package ticketprice.domain.cinema;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.EqualsAndHashCode;

/**
 * 上映日時.
 */
@EqualsAndHashCode
public class ScreenTime {

    private final LocalDate date;
    private final LocalTime time;

    private ScreenTime(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public static ScreenTime of(LocalDateTime dateTime) {
        return new ScreenTime(dateTime.toLocalDate(), dateTime.toLocalTime());
    }

    /**
     * 平日かどうか.
     */
    public boolean isWeekDay() {
        return !(isWeekend() || isHoliday());
    }

    /**
     * 土日かどうか.
     */
    public boolean isWeekend() {
        return dayOfWeek() == DayOfWeek.SATURDAY || dayOfWeek() == DayOfWeek.SUNDAY;
    }

    private DayOfWeek dayOfWeek() {
        return date.getDayOfWeek();
    }

    /**
     * 祝日かどうか.
     */
    public boolean isHoliday() {
        // TODO: 未実装
        return false;
    }

    /**
     * 映画の日かどうか.
     */
    public boolean isCinemaDay() {
        return date.getDayOfMonth() == 1;
    }

    /**
     * レイトショーかどうか.
     */
    public boolean isLateShow() {
        return time.getHour() >= 20;
    }
}
