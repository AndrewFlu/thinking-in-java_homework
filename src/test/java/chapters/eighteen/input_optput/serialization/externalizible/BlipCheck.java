package chapters.eighteen.input_optput.serialization.externalizible;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class BlipCheck implements Externalizable {

    // Т.к. других явно объявленных конструкторов класса нет, Java сама создаст конструктор по умолчанию при компиляции.
    // Поэтому необходимости в таком конструкторе нет
//    public BlipCheck() {
//        System.out.println("Blip2 Constructor");
//    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal()");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal()");
    }
}
