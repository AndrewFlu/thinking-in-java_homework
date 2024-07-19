package chapters.five.overloading.chapters.five;

public class Initialise {
    String initInDeclare = "Initial value";
    String initInConstructor;

    public Initialise(String initInConstructor) {
        this.initInConstructor = initInConstructor;
    }

    public Initialise() {
    }
}

class InitialiseTestDrive {
    public static void main(String[] args) {
        Initialise init = new Initialise();
        Initialise withInitial = new Initialise("MacBook");
        System.out.println("default value for not initialised object — " + init.initInDeclare);
        System.out.println("Initialised value in constructor — " + withInitial.initInConstructor);
    }
}
