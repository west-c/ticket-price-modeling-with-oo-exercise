package ticketprice.application;

import ticketprice.domain.ticket.DetermineReasonablePlanService;
import ticketprice.domain.audience.Age;
import ticketprice.domain.audience.Audience;
import ticketprice.domain.audience.DiscountList;
import ticketprice.domain.audience.StudentType;
import ticketprice.domain.cinema.ScreenTime;
import ticketprice.domain.ticket.Ticket;
import ticketprice.domain.ticket.plan.TicketPlan;

public class IssueTicketService {

    private DetermineReasonablePlanService determineReasonablePlanService = new DetermineReasonablePlanService();

    public Ticket issue(Age age, StudentType studentType, DiscountList discountList, ScreenTime screenTime) {
        Audience audience = new Audience(age, studentType);

        TicketPlan ticketPlan = determineReasonablePlanService.determine(audience, discountList, screenTime);

        return Ticket.issue(ticketPlan, screenTime);
    }
}
