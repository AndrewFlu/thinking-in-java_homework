package chapters.fifteen.generics.instantiate.withoutconstraint;

import static net.mindview.utils.Print.print;

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> factory = new ClassAsFactory<>(Employee.class);
        print("ClassAsFactory<Employee> succeeded");

        try {
            ClassAsFactory<Integer> integerFactory = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            print("ClassAsFactory<Integer> failed");
        }
    }
}
