package ticketprice.application;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import ticketprice.domain.audience.Discount;
import ticketprice.domain.audience.DiscountList;
import ticketprice.domain.audience.StudentType;
import org.junit.jupiter.params.provider.Arguments;

public class IssueTicketServiceTestProvider {

    static Stream<Arguments> provider() {
        return Stream.of(
            arguments("シネマシティズン／平日／レイトショー",
                59, StudentType.UNIVERSITY, new DiscountList(Discount.CINEMA_CITIZEN), "2021-09-10 21:00",
                "シネマシティズン", 1000),

            arguments("シネマシティズン／土日祝／～20:00",
                20, StudentType.NONE, new DiscountList(Discount.CINEMA_CITIZEN), "2021-09-11 13:00",
                "シネマシティズン", 1300),

            arguments("シネマシティズン／映画の日（土日祝）／～20:00",
                20, StudentType.NONE, new DiscountList(Discount.CINEMA_CITIZEN), "2021-08-01 13:00",
                "シネマシティズン", 1100),

            arguments("シネマシティズン／映画の日（平日）／～20:00",
                59, StudentType.UNIVERSITY, new DiscountList(Discount.CINEMA_CITIZEN), "2021-09-01 13:00",
                "シネマシティズン", 1000),

            arguments("シネマシティズン（60才以上）／平日／～20:00",
                60, StudentType.NONE, new DiscountList(Discount.CINEMA_CITIZEN, Discount.MICARD), "2021-09-10 13:00",
                "シネマシティズン（60才以上）", 1000),

            arguments("一般／平日／～20:00",
                69, StudentType.NONE, new DiscountList(), "2021-09-10 19:00",
                "一般", 1800),

            arguments("一般／土日祝／レイトショー",
                20, StudentType.NONE, new DiscountList(), "2021-09-11 20:00",
                "一般", 1300),

            arguments("一般／映画の日／レイトショー",
                20, StudentType.NONE, new DiscountList(), "2021-09-01 20:00",
                "一般", 1100),

            arguments("シニア／平日／～20:00",
                70, StudentType.NONE, new DiscountList(), "2021-09-10 13:00",
                "シニア（70才以上）", 1100),

            arguments("学生（大・専）／平日／～20:00",
                20, StudentType.UNIVERSITY, new DiscountList(), "2021-09-10 13:00",
                "学生（大・専）", 1500),

            arguments("中・高校生／平日／～20:00",
                16, StudentType.JUNIOR_AND_HIGH_SCHOOL, new DiscountList(), "2021-09-10 13:00",
                "中・高校生", 1000),

            arguments("幼児／平日／～20:00",
                3, StudentType.NONE, new DiscountList(), "2021-09-10 13:00",
                "幼児（3才以上）・小学生", 1000),

            arguments("小学生／土日祝／～20:00",
                7, StudentType.ELEMENTARY_SCHOOL, new DiscountList(), "2021-09-11 13:00",
                "幼児（3才以上）・小学生", 1000),

            arguments("障がい者（学生以上）／平日／～20:00",
                75, StudentType.NONE, new DiscountList(Discount.HANDICAPPED), "2021-09-10 13:00",
                "障がい者（学生以上）", 1000),

            arguments("障がい者（高校以下）／平日／～20:00",
                8, StudentType.ELEMENTARY_SCHOOL, new DiscountList(Discount.HANDICAPPED), "2021-09-10 13:00",
                "障がい者（高校以下）", 900),

            arguments("エムアイカード／映画の日（平日）／～20:00",
                20, StudentType.NONE, new DiscountList(Discount.MICARD), "2021-09-01 13:00",
                "エムアイカード", 1600),

            arguments("エムアイカード／映画の日（土日祝）／レイトショー",
                20, StudentType.NONE, new DiscountList(Discount.MICARD), "2021-08-01 20:00",
                "エムアイカード", 1300)
        );
    }
}
