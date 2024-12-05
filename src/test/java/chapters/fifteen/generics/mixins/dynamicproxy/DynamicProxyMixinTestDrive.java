package chapters.fifteen.generics.mixins.dynamicproxy;

import chapters.fifteen.generics.mixins.*;

import static chapters.fifteen.generics.tuples.inferedtypes.Tuple.tuple;

public class DynamicProxyMixinTestDrive {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImpl(), Basic.class),
                tuple(new TimeStampedImpl(), TimeStamped.class),
                tuple(new SerialNumberedImpl(), SerialNumbered.class)
        );

        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;

        b.set("Hi!");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumbered());
    }
}
