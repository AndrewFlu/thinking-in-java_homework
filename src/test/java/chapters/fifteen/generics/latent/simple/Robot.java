package chapters.fifteen.generics.latent.simple;

import static net.mindview.utils.Print.print;

public class Robot implements Performs{
    @Override
    public void speak() {
        print("Click!");
    }

    @Override
    public void sit() {
        print("Clank!");
    }

    public void oilChange(){};
}
