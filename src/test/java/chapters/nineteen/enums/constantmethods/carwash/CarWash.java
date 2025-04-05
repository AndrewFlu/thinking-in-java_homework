package chapters.nineteen.enums.constantmethods.carwash;

import java.util.EnumSet;

import static net.mindview.utils.Print.print;

public class CarWash {

    public enum Cycle {
        UNDERBOBY {
            @Override
            void action() {
                print("Spraying the underbody");
            }
        },
        WHEELWASH {
            @Override
            void action() {
                print("Washing the wheels");
            }
        },
        PREWASH {
            @Override
            void action() {
                print("Loosening the dirt");
            }
        },
        BASIC {
            @Override
            void action() {
                print("The basic wash");
            }
        },
        HOTWAX {
            @Override
            void action() {
                print("Appling hot wax");
            }
        },
        RINSE {
            @Override
            void action() {
                print("Rinsing");
            }
        },
        BLOWDRY {
            @Override
            void action() {
                print("Blowing dry");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void washCar() {
        for (Cycle c : cycles)
            c.action();
    }

    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        print(carWash);

        carWash.washCar();
        // порядок добавления не важен
        carWash.add(Cycle.BLOWDRY);
        carWash.add(Cycle.BLOWDRY); //  дубликаты игнорируются
        carWash.add(Cycle.RINSE);
        carWash.add(Cycle.HOTWAX);
        print(carWash);
        carWash.washCar();
    }
}
