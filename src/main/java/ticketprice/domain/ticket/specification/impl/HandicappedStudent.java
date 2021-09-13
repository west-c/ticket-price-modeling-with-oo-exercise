package ticketprice.domain.ticket.specification.impl;

import ticketprice.domain.audience.Audience;
import ticketprice.domain.audience.DiscountList;
import ticketprice.domain.ticket.TicketName;
import ticketprice.domain.ticket.price.Price;
import ticketprice.domain.ticket.price.PriceType;
import ticketprice.domain.ticket.specification.TicketSpecification;

public class HandicappedStudent implements TicketSpecification {

    @Override
    public TicketName ticketName() {
        return TicketName.of("障がい者（高校以下）");
    }

    @Override
    public boolean isAppliedTo(Audience audience, DiscountList discountList) {
        return discountList.isHandicapped() && audience.isHighSchoolAndBelow();
    }

    @Override
    public Price price(PriceType type) {
        switch (type) {
            case WEEKDAY:
            case WEEKDAY_LATE:
            case WEEKEND_AND_HOLIDAY:
            case WEEKEND_AND_HOLIDAY_LATE:
            case CINEMA_DAY_ON_WEEKDAY:
            case CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY:
            case CINEMA_DAY_ON_WEEKDAY_LATE:
            case CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY_LATE:
                return Price.of(900);

            default:
                throw new IllegalArgumentException();
        }
    }
}
