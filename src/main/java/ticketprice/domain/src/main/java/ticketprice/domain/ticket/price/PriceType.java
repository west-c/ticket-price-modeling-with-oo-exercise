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
        if (screenTime.isCinemaDay()) {
            return priceTypeOfCinemaDay(screenTime);
        }
        if (screenTime.isWeekDay()) {
            return priceTypeOfWeekDay(screenTime);
        }
        return priceTypeOfWeekend(screenTime);
    }

    private static PriceType priceTypeOfCinemaDay(ScreenTime screenTime) {
        if (!screenTime.isLateShow()) {
            return screenTime.isWeekDay() ? CINEMA_DAY_ON_WEEKDAY : CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY;
        }
        return screenTime.isWeekDay() ? CINEMA_DAY_ON_WEEKDAY_LATE : CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY_LATE;
    }

    private static PriceType priceTypeOfWeekDay(ScreenTime screenTime) {
        return screenTime.isLateShow() ? WEEKDAY_LATE : WEEKDAY;
    }

    private static PriceType priceTypeOfWeekend(ScreenTime screenTime) {
        return screenTime.isLateShow() ? WEEKEND_AND_HOLIDAY_LATE : WEEKEND_AND_HOLIDAY;
    }
}
