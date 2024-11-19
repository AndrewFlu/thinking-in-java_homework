package chapters.fifteen.generics.casting;

import chapters.fifteen.generics.instantiate.withconstraint.Widget;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0])
        );

        List<Widget> shapes = List.class.cast(in.readObject());
    }
}
