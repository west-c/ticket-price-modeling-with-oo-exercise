package ticketprice.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import ticketprice.domain.audience.Age;
import ticketprice.domain.audience.DiscountList;
import ticketprice.domain.audience.StudentType;
import ticketprice.domain.cinema.ScreenTime;
import ticketprice.domain.ticket.Ticket;
import ticketprice.domain.ticket.TicketName;
import ticketprice.domain.ticket.price.Price;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IssueTicketServiceTest {

    IssueTicketService issueTicketService = new IssueTicketService();

    @ParameterizedTest
    @MethodSource("issueTicketServiceTestProvider")
    public void issue(String testCase, int age, StudentType studentType, DiscountList discountList, String screenTime,
                      String expectedTicketName, int expectedPrice) {
        Ticket actual = issueTicketService.issue(Age.of(age), studentType, discountList, screenTime(screenTime));
        assertEquals(expected(expectedTicketName, expectedPrice), actual);
    }

    static Stream<Arguments> issueTicketServiceTestProvider() {
        return IssueTicketServiceTestProvider.provider();
    }

    private ScreenTime screenTime(String screenTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(screenTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return ScreenTime.of(localDateTime);
    }

    private Ticket expected(String ticketName, int price) {
        return new Ticket(TicketName.of(ticketName), Price.of(price));
    }
}
