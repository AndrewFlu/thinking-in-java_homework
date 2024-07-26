package chapters.seven.inheritance.initialisation;

public class InheritanceInitializationTestDrive {
    public static void main(String[] args) {
        Grandson grandson = new Grandson();

        System.out.println(grandson.baseString);
        System.out.println("Base.baseStaticInteger = " + grandson.baseStaticInteger);
        System.out.println("Grandson.grandsonStaticInteger = " + grandson.grandsonStaticInteger);

        Grandson grandson1 = new Grandson();
        System.out.println("Grandson.grandsonStaticInteger = " + grandson1.grandsonStaticInteger);

    }
}
