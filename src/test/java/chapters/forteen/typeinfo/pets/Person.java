package chapters.forteen.typeinfo.pets;

public class Person extends Individual {
    public Person(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("My name is " + super.getName());
    }
}
