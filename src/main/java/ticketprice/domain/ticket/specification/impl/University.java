package ticketprice.domain.ticket.specification.impl;

import ticketprice.domain.audience.Audience;
import ticketprice.domain.audience.DiscountList;
import ticketprice.domain.ticket.TicketName;
import ticketprice.domain.ticket.price.Price;
import ticketprice.domain.ticket.price.PriceType;
import ticketprice.domain.ticket.specification.TicketSpecification;

public class University implements TicketSpecification {

    @Override
    public TicketName ticketName() {
        return TicketName.of("学生（大・専）");
    }

    @Override
    public boolean isAppliedTo(Audience audience, DiscountList discountList) {
        return audience.isUniversity();
    }

    @Override
    public Price price(PriceType type) {
        switch (type) {
            case WEEKDAY:
            case WEEKEND_AND_HOLIDAY:
                return Price.of(1500);

            case WEEKDAY_LATE:
            case WEEKEND_AND_HOLIDAY_LATE:
                return Price.of(1300);

            case CINEMA_DAY_ON_WEEKDAY:
            case CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY:
            case CINEMA_DAY_ON_WEEKDAY_LATE:
            case CINEMA_DAY_ON_WEEKEND_AND_HOLIDAY_LATE:
                return Price.of(1100);

            default:
                throw new IllegalArgumentException();
        }
    }
}
