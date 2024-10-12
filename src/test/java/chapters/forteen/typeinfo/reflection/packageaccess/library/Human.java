package chapters.forteen.typeinfo.reflection.packageaccess.library;

public class Human {
    private String name;
    private long salary;

    public Human(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public void sayName() {
        System.out.println("My name is " + name);
    }

    protected void takeCar() {
        System.out.println("Можешь взять мою машину покататься на выходных");
    }

    void sayCountry() {
        System.out.println("I am living in Russia");
    }

    private void saySalary() {
        System.out.println("My salary is " + salary + " rubbles");
    }
}
