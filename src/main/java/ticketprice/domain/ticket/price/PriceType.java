package ticketprice.domain.ticket.price;

import ticketprice.domain.cinema.ScreenTime;

public enum PriceType {

    WEEKDAY,
    WEEKDAY_LATE,
    WEEKEND_AND_HOLIDAY,
    WEEKEND_AND_HOLIDAY_LATE,
    CINEMA_DAY_ON_WEEKDAY,
    CINEMA_DAY_ON_WEEKDAY_LATE,
    CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY,
    CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY_LATE;

    public static PriceType of(ScreenTime screenTime) {
        if (screenTime.isCinemaDay() && !screenTime.isLateShow()) {
            return screenTime.isWeekDay() ? CINEMA_DAY_ON_WEEKDAY : CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY;
        }
        if (screenTime.isCinemaDay() && screenTime.isLateShow()) {
            return screenTime.isWeekDay() ? CINEMA_DAY_ON_WEEKDAY_LATE : CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY_LATE;
        }
        if (screenTime.isWeekDay()) {
            return screenTime.isLateShow() ? WEEKDAY_LATE : WEEKDAY;
        }
        if (screenTime.isWeekend() || screenTime.isHoliday()) {
            return screenTime.isLateShow() ? WEEKEND_AND_HOLIDAY_LATE : WEEKEND_AND_HOLIDAY;
        }

        throw new IllegalStateException("price type not defined.");
    }
}
