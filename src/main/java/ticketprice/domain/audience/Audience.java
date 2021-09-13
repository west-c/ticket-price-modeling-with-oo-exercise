package ticketprice.domain.audience;

public class Audience {

    private final Age age;
    private final StudentType studentType;

    public Audience(Age age, StudentType studentType) {
        this.age = age;
        this.studentType = studentType;
    }

    /**
     * 指定した年齢以上かどうか.
     */
    public boolean isYearsAndOver(int age) {
        return this.age.isYearsAndOver(age);
    }

    /**
     * 幼児かどうか.
     */
    public boolean isInfant() {
        return age.isInfant();
    }

    /**
     * 小学生かどうか.
     */
    public boolean isElementarySchool() {
        return studentType == StudentType.ELEMENTARY_SCHOOL;
    }

    /**
     * 中・高校生かどうか.
     */
    public boolean isJuniorAndHighSchool() {
        return studentType == StudentType.JUNIOR_AND_HIGH_SCHOOL;
    }

    /**
     * 学生（大・専）かどうか.
     */
    public boolean isUniversity() {
        return studentType == StudentType.UNIVERSITY;
    }

    /**
     * 高校以下かどうか.
     */
    public boolean isHighSchoolAndBelow() {
        return isJuniorAndHighSchool() || isElementarySchool() || isInfant();
    }
}
