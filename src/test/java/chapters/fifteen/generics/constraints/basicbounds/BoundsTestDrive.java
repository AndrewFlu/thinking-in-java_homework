package chapters.fifteen.generics.constraints.basicbounds;

public class BoundsTestDrive {
    public static void main(String[] args) {
        Solid<Bounded> boundedSolid = new Solid<>(new Bounded());

        System.out.println(boundedSolid.color());
        System.out.println(boundedSolid.getX());
        System.out.println(boundedSolid.weight());
    }
}
