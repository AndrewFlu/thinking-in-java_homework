package chapters.fifteen.generics.primitives;

import chapters.fifteen.generics.compilerintelligence.Holder;

public class HoldersTestDrive {
    public static void main(String[] args) {

        System.out.println("Boolean:");
        Holder<Boolean> booleanHolder = new Holder<>(false);
        boolean holderValue = booleanHolder.getValue();
        System.out.println(holderValue);
        booleanHolder.setValue(true);
        System.out.println(booleanHolder.getValue());

        System.out.println("Byte:");
        Holder<Byte> byteHolder = new Holder<>(Byte.MAX_VALUE);
        Byte byteValue = byteHolder.getValue();
        System.out.println(byteValue);
        byteHolder.setValue((byte) 11);
        System.out.println(byteHolder.getValue());

        System.out.println("Short:");
        Holder<Short> shortHolder = new Holder<>((short) 15);
        short shortHolderValue = shortHolder.getValue();
        System.out.println(shortHolderValue);
        shortHolder.setValue((short) 150);
        System.out.println(shortHolder.getValue());

        System.out.println("Integer:");
        Holder<Integer> integerHolder = new Holder<>(7);
        Integer value = integerHolder.getValue();
        System.out.println(value);
        integerHolder.setValue(1);
        Integer value1 = integerHolder.getValue();
        System.out.println(value1);

        System.out.println("Long");
        Holder<Long> longHolder = new Holder<>(12345L);
        long longHolderValue = longHolder.getValue();
        System.out.println(longHolderValue);
        longHolder.setValue(15L);
        System.out.println(longHolder.getValue());

        System.out.println("Float:");
        Holder<Float> floatHolder = new Holder<>(7F);
        Float value3 = floatHolder.getValue();
        System.out.println(value3);
        float newFloatValue = 150.0F;
        floatHolder.setValue(newFloatValue);
        System.out.println(floatHolder.getValue());

        System.out.println("Double:");
        Holder<Double> doubleHolder = new Holder<>(5.5);
        System.out.println(doubleHolder.getValue());
        double value2 = 1.1;
        doubleHolder.setValue(value2);
        System.out.println(doubleHolder.getValue());

        System.out.println("Character:");
        Holder<Character> characterHolder = new Holder<>('a');
        char characterHolderValue = characterHolder.getValue();
        System.out.println(characterHolderValue);
        characterHolder.setValue('b');
        System.out.println(characterHolder.getValue());
    }
}
