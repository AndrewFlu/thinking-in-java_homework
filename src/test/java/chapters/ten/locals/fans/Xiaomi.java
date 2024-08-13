package chapters.ten.locals.fans;

public class Xiaomi {

    private class MiFan2 implements IFan {

        @Override
        public void in() {
            System.out.println("Xiaomi Mi Fan 2 is ON");
        }

        @Override
        public void off() {
            System.out.println("Xiaomi Mi Fan 2 is OFF");
        }
    }

    private class MiFanLight implements IFan {

        @Override
        public void in() {
            System.out.println("Xiaomi Mi Fan Light is ON");
        }

        @Override
        public void off() {
            System.out.println("Xiaomi Mi Fan Light is OFF");

        }
    }

    IFan getMiFan2() {
        return this.new MiFan2();
    }

    IFan getMiFanLight() {
        return this.new MiFanLight();
    }
}
