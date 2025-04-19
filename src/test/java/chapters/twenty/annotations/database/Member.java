package chapters.twenty.annotations.database;

@DBTable(name = "MEMBER")
public class Member {

    static int memberCount;

    @SQLBoolean
    Boolean isMale;

    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLCharacter(100)
    String address;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public Boolean getMale() {
        return isMale;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return handle;
    }
}
