package chapters.nineteen.enums.finite_state.vanding_machine.taks10;

import chapters.nineteen.enums.finite_state.Input;
import net.mindview.utils.Generator;
import net.mindview.utils.TextFile;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

import static net.mindview.utils.Print.print;

public class VendingMachine_Task10 {
    static int count = 0;

    int id = ++count;

    State state = State.RESTING;

    int amount = 0; // для каждой транзакции
    int banked = 0; // остаток после покупки

    Input input = null;
    Input selection = null;
    boolean isTransient = false;

    // Enums is static, so use classes instead
    class RestingDo implements Command {

        @Override
        public void next(Input in) {
            isTransient = false;
            input = in;
            switch (Category10.categorise(in)) {
                case Category10.MONEY:
                    amount += in.amount();
                    state = State.ADDING_MONEY;
                    break;
                case SHUT_DOWN:
                    state = State.TERMINAL;
                default:
            }
        }

        @Override
        public void next() {
            isTransient = false;
        }
    }

    class AddingMoneyDo implements Command {

        @Override
        public void next(Input in) {
            isTransient = false;
            switch (Category10.categorise(in)) {
                case MONEY:
                    amount += in.amount();
                    break;
                case ITEM_SELECTION:
                    selection = in;
                    if (amount < selection.amount())
                        System.out.println("Insufficient money for " + selection);
                    else {
                        state = State.DISPENSING;
                        isTransient = true;
                    }
                    break;
                case QUIT_TRANSACTION:
                    state = State.GIVING_CHANGE;
                    isTransient = true;
                    break;
                case SHUT_DOWN:
                    state = State.TERMINAL;
                    banked += amount;
                default:
            }
        }

        @Override
        public void next() {
            isTransient = false;
        }
    }

    class DispensingDo implements Command {

        @Override
        public void next(Input in) {
            isTransient = true;
            System.out.println("Here is your selection: " + selection);
            state = State.GIVING_CHANGE;
        }

        @Override
        public void next() {
            isTransient = true;
            System.out.println("Here is your selection: " + selection);
            state = State.GIVING_CHANGE;
        }
    }

    class GivingChangeDo implements Command {

        @Override
        public void next(Input input) {
            isTransient = true;
            if (amount > selection.amount())
                System.out.println("Your change: " + (amount - selection.amount()));
            banked = banked += selection.amount();
            amount = 0; // reset
            state = State.RESTING;
        }

        @Override
        public void next() {
            isTransient = true;
            if (amount < selection.amount())
                System.out.println("Returning your amount: " + amount);
            if (amount > selection.amount()) {
                System.out.println("Your change: " + (amount - selection.amount()));
                banked += selection.amount();
            }
            if (amount == selection.amount())
                banked += selection.amount();
            amount = 0;
            state = State.RESTING;

        }
    }

    class TerminalDo implements Command {

        @Override
        public void next(Input input) {
            System.out.println("State Terminal");
            isTransient = false;
        }

        @Override
        public void next() {
            System.out.println("State Terminal");
            isTransient = false;
        }
    }

    Map<State, Command> em = Collections.synchronizedMap(new EnumMap<>(State.class));

    // Load up the EnumMap in the Constructor
    VendingMachine_Task10() {
        print("VendingMachine_Task10() with id: " + id);
        em.put(State.RESTING, new RestingDo());
        em.put(State.ADDING_MONEY, new AddingMoneyDo());
        em.put(State.DISPENSING, new DispensingDo());
        em.put(State.GIVING_CHANGE, new GivingChangeDo());
        em.put(State.TERMINAL, new TerminalDo());
    }

    void showAmount() {
        print("amount = " + amount);
    }

    void showBanked() {
        print("Banked = " + banked);
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1)
            gen = new FileInputGenerator10(args[0]);
        VendingMachine_Task10 vm10a = new VendingMachine_Task10();
        VendingMachine_Task10 vm10b = new VendingMachine_Task10();
        VendingMachine_Task10 vm10c = new VendingMachine_Task10();
        print();

//        print("Testing VendingMachine 10a:");
//        while (vm10a.state != State.TERMINAL) {
//            Input in = gen.next();
//            vm10a.em.get(vm10a.state).next(in);
//            while (vm10a.isTransient) {
//                vm10a.em.get(vm10a.state).next();
//            }
//            vm10a.showAmount();
//            vm10a.showBanked();
//        }
//        print();

        print("Testing vending machine 10b:");
        gen = new FileInputGenerator10("src/test/java/chapters/nineteen/enums/finite_state/vanding_machine/taks10/VM10b.txt");
        while (vm10b.state != State.TERMINAL) {
            Input in = gen.next();
            (vm10b.em.get(vm10b.state)).next(in);
            while (vm10b.isTransient)
                (vm10b.em.get(vm10b.state)).next();
            vm10b.showAmount();
            vm10b.showBanked();
        }

        print();
        print("Testing vending machine 10c:");
        gen = new FileInputGenerator10("src/test/java/chapters/nineteen/enums/finite_state/vanding_machine/taks10/VM10c.txt");
        while (vm10c.state != State.TERMINAL) {
            Input in = gen.next();
            vm10c.em.get(vm10c.state).next(in);
            while (vm10c.isTransient)
                vm10c.em.get(vm10c.state).next();
            vm10c.showAmount();
            vm10c.showBanked();
        }
    }


    // Для простейшей проверки работоспособности:
    static class RandomInputGenerator implements Generator<Input> {
        @Override
        public Input next() {
            return Input.randomSelection();
        }
    }

    // Создание данных Input по файлу строк, разделённых символом ';'
    static class FileInputGenerator10 implements Generator<Input> {
        private Iterator<String> input;

        public FileInputGenerator10(String fileName) {
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
