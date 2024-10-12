package chapters.forteen.typeinfo.reflection.packageaccess.outer;

import chapters.forteen.typeinfo.reflection.packageaccess.library.Human;

public class Woman extends Human {
    Human husband;

    public Woman(String name, Human husband) {
        super(name, 0);
        this.husband = husband;
    }

    public void printProtectedMethodInfo() {
        super.takeCar();
    }
}
