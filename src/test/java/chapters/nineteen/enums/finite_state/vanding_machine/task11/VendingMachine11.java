package chapters.nineteen.enums.finite_state.vanding_machine.task11;

import net.mindview.utils.Generator;

import static net.mindview.utils.Print.print;

public class VendingMachine11 {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static VendedItem selection = null;

    enum StateDuration {TRANSIENT} //  Перечисление для пометки

    enum State {
        RESTING {
            void next(VendingInput input) {
                if (input instanceof MonetaryUnit) {
                    amount += ((MonetaryUnit) input).getAmount();
                    state = ADDING_MONEY;
                }
                if (input instanceof VendingEvents) {
                    if (input.getName().equals("Stop"))
                        state = TERMINAL;
                }
            }
        },
        ADDING_MONEY {
            void next(VendingInput input) {
                if (input instanceof MonetaryUnit)
                    amount += ((MonetaryUnit) input).getAmount();
                if (input instanceof VendedItem) {
                    selection = (VendedItem) input;
                    if (amount < selection.getAmount())
                        System.out.println("Insufficient money for " + selection);
                    else
                        state = DISPENSING;
                }
                if (input instanceof VendingEvents) {
                    if (input.getName().equals("AbortTransaction"))
                        state = GIVING_CHANGE;
                    if (input.getName().equals("Stop"))
                        state = TERMINAL;
                }

            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                print("Here is your " + selection);
                amount -= selection.getAmount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if (amount > 0) {
                    print("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            void output() {
                print("Halted");
            }
        },
        ;

        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(VendingInput input) {
            throw new RuntimeException("Only call " +
                    "next(VendingInput input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for" +
                    "StateDuration.TRANSIENT states");
        }

        void output() {
            print(amount);
        }
    }

    static void run(Generator<VendingInput> generator) {
        while (state != State.TERMINAL) {
            state.next(((FileInputGenerator11) generator).next());
            while (state.isTransient)
                state.next();
            state.output();
        }
        state = State.RESTING;
        print();
    }

    static void runRandom(Generator<VendingInput> generator) {
        while (state != State.TERMINAL) {
            state.next(((FileInputGenerator11) generator).randomNext());
            while (state.isTransient)
                state.next();
            state.output();
        }
        state = State.RESTING;
        print();
    }

    static void runTextExample(Generator<VendingInput> generator) {
        for (int i = 0; i < 16; i++) {
            state.next(((FileInputGenerator11) generator).textExampleNext("src/test/java/chapters/nineteen/enums/finite_state/vanding_machine/task11/VendingMachineInput11.txt"));
            while (state.isTransient)
                state.next();
            state.output();
        }
        state = State.RESTING;
        print();
    }

    public static void main(String[] args) {
        FileInputGenerator11 gen = new FileInputGenerator11("src/test/java/chapters/nineteen/enums/finite_state/vanding_machine/task11/VendingMachineInput11.txt");
        run(gen);
        runRandom(gen);
        runTextExample(gen);
    }
}
