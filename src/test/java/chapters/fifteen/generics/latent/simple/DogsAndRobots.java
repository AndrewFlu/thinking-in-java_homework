package chapters.fifteen.generics.latent.simple;

public class DogsAndRobots {
    public static void main(String[] args) {
        PerformingDog dog = new PerformingDog();
        Robot robot = new Robot();

        Communicate.perform(dog);
        Communicate.perform(robot);
    }
}
