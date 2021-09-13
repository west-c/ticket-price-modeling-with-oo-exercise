package ticketprice.domain.audience;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Age {

    private final int age;

    private Age(int age) {
        this.age = age;
    }

    public static Age of(int age) {
        return new Age(age);
    }

    boolean isYearsAndOver(int age) {
        return this.age >= age;
    }

    boolean isInfant() {
        return age >= 3 && age <= 6;
    }
}
