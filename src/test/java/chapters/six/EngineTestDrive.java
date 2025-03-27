package chapters.six;

import chapters.six.packageprivate.DieselEngine;
import chapters.six.packageprivate.Engine;

import static net.mindview.utils.Print.print;

public class EngineTestDrive {
    public static void main(String[] args) {
        Engine e81Engine = new DieselEngine("N47D20A");
        e81Engine.start();
        e81Engine.stop();

        System.out.println(String.format("Тип двигателя: %s", e81Engine.getModel()));

        DieselEngine f25engine = new DieselEngine("1");
//        f25engine.setModel("N57");

        print(f25engine.getModel());
    }
}
