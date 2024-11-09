package chapters.fifteen.generics.constraints.inheritbounds;

import chapters.fifteen.generics.constraints.basicbounds.Bounded;

public class InheritBoundsTestDrive {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());

        System.out.println(solid2.color());
        System.out.println(solid2.getY());
        System.out.println(solid2.weight());
    }
}
