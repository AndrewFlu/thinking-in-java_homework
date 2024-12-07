package chapters.forteen.typeinfo.pets;

public class Rodent extends Pet{
    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Pi-pi-pi-pi!");
    }
}
