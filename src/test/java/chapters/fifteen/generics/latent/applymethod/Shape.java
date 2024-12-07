package chapters.fifteen.generics.latent.applymethod;

import static net.midview.Print.print;

public class Shape {
    public void rotate() {
        print(this + " rotate");
    }

    public void resize(int newSize) {
        print(this + " resize " + newSize);
    }
}
