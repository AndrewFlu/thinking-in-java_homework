package chapters.forteen.typeinfo.sweetshop;

import static net.midview.Print.print;

public class SweetShop {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: Candy (or Cookie)");
            System.exit(1);
        }
        print("В методе main()");
        switch (args[0]) {
            case "Candy" -> {
                new Candy();
                print("После создания объекта Candy");
            }
            case "Cookie" -> {
                new Cookie();
                print("После создания объекта Cookie");
            }
            default -> throw new IllegalArgumentException("Не удалось создать экземпляр " + args[0]);
        }
    }
}
