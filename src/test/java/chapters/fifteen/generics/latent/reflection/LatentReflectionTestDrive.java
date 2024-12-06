package chapters.fifteen.generics.latent.reflection;

public class LatentReflectionTestDrive {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Mime());
    }
}
