package chapters.nine.interfaceexamples.adventure;

public class Adventure {
    public static void main(String[] args) {
        Hero hero = new Hero();
        doSwim(hero);
        doFly(hero);
        doFight(hero);
        doClimb(hero);
        doCharacterFight(hero);
    }

    private static void doClimb(CanClimb x) {
        x.climb();
    }

    private static void doCharacterFight(ActionCharacter y) {
        y.fight();
    }

    private static void doFight(CanFight x) {
        x.fight();
    }

    private static void doFly(CanFly x) {
        x.fly();
    }

    private static void doSwim(CanSwim x) {
        x.swim();
    }
}
