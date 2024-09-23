package chapters.forteen.typeinfo.sweetshop;

import static net.midview.Print.print;

public class SweetShop {
    public static void main(String[] args) {
        print("В методе main()");
        new Candy();
        print("После создания объекта Candy");
        try {
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            print("Не удалось найти класс Gum");
        }
        print("После вызова метода Class.forName(\"Gum\")");
        new Cookie();
        print("После создания объекта Cookie");
    }
}
