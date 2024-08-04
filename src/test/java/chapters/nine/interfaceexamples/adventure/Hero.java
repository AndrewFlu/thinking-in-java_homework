package chapters.nine.interfaceexamples.adventure;

public class Hero extends ActionCharacter implements CanFly, CanFight, CanSwim {

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + ".fly()");
    }

    @Override
    public void swim() {
        System.out.println(getClass().getSimpleName() + ".swim()");
    }
}
