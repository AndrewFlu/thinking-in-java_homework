package chapters.fifteen.generics.mixins.dynamicproxy;

import chapters.fifteen.generics.mixins.*;

import java.awt.*;

import static chapters.fifteen.generics.tuples.inferedtypes.Tuple.tuple;

public class DynamicProxyMixinTestDrive {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImpl(), Basic.class),
                tuple(new TimeStampedImpl(), TimeStamped.class),
                tuple(new SerialNumberedImpl(), SerialNumbered.class),
                tuple(new ColoredImpl(), Colored.class)
        );

        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        Colored c = (Colored) mixin;

        b.set("Hi!");
        c.setColor(Color.BLUE);
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumbered());
        System.out.println(c.getColor());
    }
}
