package chapters.sixteen.arrays.generators.skipgenerator;

import net.mindview.utils.Generator;

public class SkipGenerator {

    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value;
//        private boolean increment;

        public Boolean(boolean increment) {
            value = increment;
        }

        @Override
        public java.lang.Boolean next() {
            boolean oldValue = value;
            value = !value;

            return oldValue;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        private byte value;
        private byte increment;

        public Byte(byte increment) {
            this.increment = increment;
        }

        @Override
        public java.lang.Byte next() {
            byte oldValue = value;
            value += increment;

            return oldValue;
        }
    }
    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class Character implements Generator<java.lang.Character> {

        private int index = 0;
        private int increment;

        public Character(int increment) {
            this.increment = increment;
        }

        @Override
        public java.lang.Character next() {
            int oldIndex = index % chars.length;
            index  += increment;

            return chars[oldIndex];
        }
    }

    public static class Short implements Generator<java.lang.Short> {
        private short value;
        private short increment;

        public Short(short increment) {
            this.increment = increment;
        }

        @Override
        public java.lang.Short next() {
            short oldValue = value;
            value += increment;

            return oldValue;
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int value;
        private int increment;

        public Integer(int increment) {
            this.increment = increment;
        }

        @Override
        public java.lang.Integer next() {
            int oldValue = value;
            value += increment;

            return oldValue;
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        private long value;
        private long increment;

        public Long(long increment) {
            this.increment = increment;
        }

        @Override
        public java.lang.Long next() {
            long oldValue = value;
            value += increment;

            return oldValue;
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        private float value;
        private float increment;

        public Float(float increment) {
            this.increment = increment;
        }

        @Override
        public java.lang.Float next() {
            float oldValue = value;
            value += increment;

            return oldValue;
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        private double value;
        private double increment;

        public Double(double increment) {
            this.increment = increment;
        }

        @Override
        public java.lang.Double next() {
            double oldValue = value;
            value += increment;

            return oldValue;
        }
    }
}
