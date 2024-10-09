package chapters.forteen.typeinfo.nullobjects;

public class Person {
    public final String firstName;
    public final String lastName;
    public final String address;

    // singleton
    public static final Person NULL = new NullPerson();

    public Person(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person: " + firstName + ' ' + lastName + ' ' + address;
    }

    public static class NullPerson extends Person implements Null {

        private NullPerson() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }
}
