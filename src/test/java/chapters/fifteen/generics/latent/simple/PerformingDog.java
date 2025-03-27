package chapters.fifteen.generics.latent.simple;

import chapters.forteen.typeinfo.pets.Dog;

import static net.mindview.utils.Print.print;

public class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {
        print("Bark!");
    }

    @Override
    public void sit() {
        print("Sitting");
    }

    public void reproduce(){};
}
