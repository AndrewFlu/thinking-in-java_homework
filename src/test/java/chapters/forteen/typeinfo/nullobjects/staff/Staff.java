package chapters.forteen.typeinfo.nullobjects.staff;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {

    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public void add(String... titles) {
        for (String title : titles) {
            add(new Position(title));
        }
    }

    public Staff(String... titles) {
        add(titles);
    }

    public boolean positionAvailable(String title) {
        for (Position position : this)
            if (position.getTitle().equals(title) && position.getPerson() == Person.NULL)
                return true;
        return false;
    }

    public void fillPosition(String title, Person hire) {
        for (Position position : this) {
            if (position.getTitle().equals(title) && position.getPerson() == Person.NULL) {
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position " + title + " not available");
    }

    public static void main(String[] args) {
        Staff staff = new Staff(
                "President",
                "CTO",
                "Marketing Manager",
                "Product Manager",
                "Software Engineer",
                "Software Engineer",
                "Software Engeneer",
                "Test Engineer",
                "Technical Writer"
        );

        staff.fillPosition("President", new Person("Andrey", "Shalagin", "Russia, Moscow"));
        staff.fillPosition("CTO", new Person("Viktor", "Kazaryan", "Russia, Moscow, North-East"));
        if (staff.positionAvailable("Software Engineer")) {
            staff.fillPosition("Software Engineer", new Person("Andrey", "Sukhov", "Ekaterinburg, Russia"));
        }

        System.out.println(staff);
    }
}
