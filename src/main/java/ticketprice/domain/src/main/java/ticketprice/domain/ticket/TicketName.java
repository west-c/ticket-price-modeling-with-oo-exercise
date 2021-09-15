package ticketprice.domain.ticket;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class TicketName {

    private final String name;

    private TicketName(String name) {
        this.name = name;
    }

    public static TicketName of(String name) {
        return new TicketName(name);
    }
}
