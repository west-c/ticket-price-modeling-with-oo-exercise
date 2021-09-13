package ticketprice.domain.ticket;

import ticketprice.domain.audience.Audience;
import ticketprice.domain.audience.DiscountList;
import ticketprice.domain.cinema.ScreenTime;
import ticketprice.domain.ticket.price.PriceType;
import ticketprice.domain.ticket.plan.ApplicablePlans;
import ticketprice.domain.ticket.plan.TicketPlan;

public class DetermineReasonablePlanService {

    public TicketPlan determine(Audience audience, DiscountList discountList, ScreenTime screenTime) {

        ApplicablePlans applicablePlans = ApplicablePlans.of(audience, discountList);
        PriceType priceType = PriceType.of(screenTime);

        return applicablePlans.reasonableTicketType(priceType);
    }
}
