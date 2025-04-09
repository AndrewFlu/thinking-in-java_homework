package chapters.nineteen.enums.finite_state.vanding_machine;

import chapters.nineteen.enums.finite_state.Input;
import net.mindview.utils.Generator;
import net.mindview.utils.TextFile;

import java.util.Iterator;

import static net.mindview.utils.Print.print;

public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {TRANSIENT} //  Перечисление для пометки

    enum State {
        RESTING {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount())
                            print("Insufficient money for " + selection);
                        else
                            state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                print("Here is your " + selection);
                amount -= selection.amount();
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

        void next(Input input) {
            throw new RuntimeException("Only call " +
                    "next(Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for" +
                    "StateDuration.TRANSIENT states");
        }

        void output() {
            print(amount);
        }
    }

    static void run(Generator<Input> generator) {
        while (state != State.TERMINAL) {
            state.next(generator.next());
            while (state.isTransient)
                state.next();
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1)
            gen = new FileInputGenerator(args[0]);
        run(gen);
    }

    // Для простейшей проверки работоспособности:
    static class RandomInputGenerator implements Generator<Input> {

        @Override
        public Input next() {
            return Input.randomSelection();
        }
    }

    // Создание данных Input по файлу строк, разделённых символом ';'
    static class FileInputGenerator implements Generator<Input> {
        private Iterator<String> input;

        public FileInputGenerator(String fileName) {
            input = new TextFile(fileName, ";").iterator();
        }

        public Input next() {
            if (!input.hasNext()) {
                return null;
            }
            return Enum.valueOf(Input.class, input.next().trim());
        }
    }

}
