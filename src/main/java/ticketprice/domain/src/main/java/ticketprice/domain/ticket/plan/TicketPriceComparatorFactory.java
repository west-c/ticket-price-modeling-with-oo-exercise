package ticketprice.domain.ticket.plan;

import java.util.Comparator;

import ticketprice.domain.ticket.price.PriceType;

/**
 * チケットプランを料金の昇順でソートする Comparator を生成するファクトリ.
 */
class TicketPriceComparatorFactory {

    static Comparator<TicketPlan> create(PriceType priceType) {
        return Comparator.comparing(o -> o.price(priceType));
    }

}
