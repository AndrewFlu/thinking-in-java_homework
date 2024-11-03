package chapters.fifteen.generics.instantiate.homework;

public class CreatorTestDrive {
    public static void main(String[] args) {
        Creator<WithArgumentClass> creator = new Creator<>(WithArgumentClass.class);

        WithArgumentClass s = creator.create(5, "Hello!");
        System.out.println(s);
    }
}
