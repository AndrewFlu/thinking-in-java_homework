package chapters.three;

public class EqualsQuest {

    public static void main(String[] args) {
        Dog tuzik = new Dog();
        tuzik.name = "Tuzik";
        tuzik.says = "av-av";
        Dog sharik = new Dog();
        sharik.name = "Sharik";
        sharik.says = "tyav-tyav";

        System.out.println("Tuzik says: " + tuzik.says);
        System.out.println("Sharik says: " + sharik.says);

        Dog ponchik = new Dog();
        ponchik.name = "Ponchik";
        ponchik.says = "ua-ua-ua";
        System.out.println("Ponchik says: " + ponchik.says);
        System.out.println("Update tuzik. So now...");
        tuzik = ponchik;
        System.out.println("Tuzik says: " + tuzik.says);
        System.out.println("Ponchik says: " + ponchik.says);

        System.out.println(ponchik == tuzik); // true
        System.out.println(ponchik.equals(tuzik) ); // true
    }
}

class Dog {
    String name;
    String says;
}
