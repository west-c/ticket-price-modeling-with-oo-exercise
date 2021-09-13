package ticketprice.domain.ticket.specification;

import ticketprice.domain.audience.Audience;
import ticketprice.domain.audience.DiscountList;
import ticketprice.domain.ticket.TicketName;
import ticketprice.domain.ticket.price.Price;
import ticketprice.domain.ticket.price.PriceType;

public interface TicketSpecification {

    TicketName ticketName();

    boolean isAppliedTo(Audience audience, DiscountList discountList);

    Price price(PriceType type);

}
