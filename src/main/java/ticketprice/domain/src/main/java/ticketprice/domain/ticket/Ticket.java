package ticketprice.domain.ticket;

import ticketprice.domain.cinema.ScreenTime;
import ticketprice.domain.ticket.price.Price;
import ticketprice.domain.ticket.price.PriceType;
import ticketprice.domain.ticket.plan.TicketPlan;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Ticket {

    private final TicketName name;
    private final Price price;

    public Ticket(TicketName name, Price price) {
        this.name = name;
        this.price = price;
    }

    public static Ticket issue(TicketPlan type, ScreenTime screenTime) {
        return new Ticket(type.ticketName(), type.price(priceType(screenTime)));
    }

    private static PriceType priceType(ScreenTime screenTime) {
        return PriceType.of(screenTime);
    }
}
