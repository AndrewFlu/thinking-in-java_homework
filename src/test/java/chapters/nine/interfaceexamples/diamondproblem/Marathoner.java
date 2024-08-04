package chapters.nine.interfaceexamples.diamondproblem;

public class Marathoner implements CanMarathon{
    @Override
    public void runMarathon() {
        System.out.println("Марафонец бежит марафон");
    }
}
