package ticketprice.domain.audience;

import java.util.Arrays;
import java.util.List;

/**
 * 保有する割引要素.
 */
public class DiscountList {

    private final List<Discount> discounts;

    public DiscountList(Discount... discounts) {
        this.discounts = Arrays.asList(discounts);
    }

    /**
     * 割引要素が空かどうか.
     */
    public boolean isEmpty() {
        return discounts.isEmpty();
    }

    /**
     * シネマシティズン会員かどうか.
     */
    public boolean isCinemaCitizen() {
        return contains(Discount.CINEMA_CITIZEN);
    }

    /**
     * 障がい者かどうか.
     */
    public boolean isHandicapped() {
        return contains(Discount.HANDICAPPED);
    }

    /**
     * エムアイカード会員かどうか.
     */
    public boolean isMicard() {
        return contains(Discount.MICARD);
    }

    private boolean contains(Discount type) {
        return discounts.contains(type);
    }
}
