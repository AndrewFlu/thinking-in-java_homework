package chapters.fifteen.generics.mixins;

import java.awt.*;

public class MixinsTestDrive {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin(), mixin3 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        mixin3.set("new Colored Added");
        mixin3.setColor(Color.PINK);

        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumbered());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumbered());
        System.out.println(mixin3.get() + " " + mixin3.getStamp() + " " + mixin3.getSerialNumbered() + " " + mixin3.getColor());
    }
}
