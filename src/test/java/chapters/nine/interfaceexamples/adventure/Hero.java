package chapters.nine.interfaceexamples.adventure;

public class Hero extends ActionCharacter implements CanFly, CanFight, CanSwim, CanClimb {

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + ".fly()");
    }

    @Override
    public void swim() {
        System.out.println(getClass().getSimpleName() + ".swim()");
    }

    @Override
    public void climb() {
        System.out.println(getClass().getSimpleName() + ".climb()");
    }
}
