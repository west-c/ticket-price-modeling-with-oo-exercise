package ticketprice.domain.ticket.plan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ticketprice.domain.audience.Audience;
import ticketprice.domain.audience.DiscountList;
import ticketprice.domain.ticket.price.PriceType;

/**
 * 適用可能なチケット一覧.
 */
public class ApplicablePlans {

    private final List<TicketPlan> plans;

    private ApplicablePlans(List<TicketPlan> plans) {
        this.plans = plans;
    }

    public static ApplicablePlans of(Audience audience, DiscountList discountList) {
        List<TicketPlan> types = new ArrayList<>();
        for (TicketPlan type : TicketPlan.values()) {
            addApplicablePlan(types, type, audience, discountList);
        }
        return new ApplicablePlans(types);
    }

    private static void addApplicablePlan(List<TicketPlan> types, TicketPlan ticketPlan, Audience audience, DiscountList discountList) {
        if (!ticketPlan.isAppliedTo(audience, discountList)) {
            return;
        }
        types.add(ticketPlan);
    }

    /**
     * 値段の最も安いチケットを算出する.
     */
    public TicketPlan reasonablePlan(PriceType priceType) {
        if (plans.isEmpty()) {
            throw new IllegalStateException();
        }
        return sortByPrice(priceType).get(0);
    }

    private List<TicketPlan> sortByPrice(PriceType priceType) {
        Comparator<TicketPlan> ticketPriceComparator = TicketPriceComparatorFactory.create(priceType);
        List<TicketPlan> sortedList = new ArrayList<>(plans);
        sortedList.sort(ticketPriceComparator);
        return sortedList;
    }
}
