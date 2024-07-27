package chapters.seven.inheritance.root;

import chapters.seven.inheritance.Amphibian;

public class Frog extends Amphibian {
    public static void main(String[] args) {
        Frog frog = new Frog();

        Amphibian amphibian = frog;
        amphibian.go();
        amphibian.swim();
    }
}
