package ticketprice.domain.ticket.plan;

import ticketprice.domain.audience.Audience;
import ticketprice.domain.audience.DiscountList;
import ticketprice.domain.ticket.TicketName;
import ticketprice.domain.ticket.price.Price;
import ticketprice.domain.ticket.price.PriceType;
import ticketprice.domain.ticket.specification.impl.CinemaCitizen;
import ticketprice.domain.ticket.specification.impl.CinemaCitizenSenior;
import ticketprice.domain.ticket.specification.impl.Handicapped;
import ticketprice.domain.ticket.specification.impl.HandicappedStudent;
import ticketprice.domain.ticket.specification.impl.InfantAndElementarySchool;
import ticketprice.domain.ticket.specification.impl.JuniorAndHighSchool;
import ticketprice.domain.ticket.specification.impl.Micard;
import ticketprice.domain.ticket.specification.impl.Normal;
import ticketprice.domain.ticket.specification.impl.Senior;
import ticketprice.domain.ticket.specification.TicketSpecification;
import ticketprice.domain.ticket.specification.impl.University;

public enum TicketPlan {

    CINEMA_CITIZEN(new CinemaCitizen()),
    CINEMA_CITIZEN_SENIOR(new CinemaCitizenSenior()),
    NORMAL(new Normal()),
    SENIOR(new Senior()),
    UNIVERSITY(new University()),
    JUNIOR_AND_HIGH_SCHOOL(new JuniorAndHighSchool()),
    INFANT_AND_ELEMENTARY_SCHOOL(new InfantAndElementarySchool()),
    HANDICAPPED(new Handicapped()),
    HANDICAPPED_STUDENT(new HandicappedStudent()),
    MICARD(new Micard());

    private final TicketSpecification specification;

    TicketPlan(TicketSpecification specification) {
        this.specification = specification;
    }

    public TicketName ticketName() {
        return specification.ticketName();
    }

    public Price price(PriceType priceType) {
        return specification.price(priceType);
    }

    boolean isAppliedTo(Audience audience, DiscountList discountList) {
        return specification.isAppliedTo(audience, discountList);
    }
}
