package ticketprice.domain.ticket.price;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Price implements Comparable<Price> {

    private final Integer value;

    private Price(Integer value) {
        if (value <= 0) {
            throw new IllegalArgumentException("price must be positive.");
        }
        this.value = value;
    }

    public static Price of(Integer price) {
        return new Price(price);
    }

    @Override
    public int compareTo(Price o) {
        return value.compareTo(o.value);
    }
}
