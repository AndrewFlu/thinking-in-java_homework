package chapters.ten.anonymous.fans;

public class Xiaomi {

    public IFan getMiLightFan() {
        return new IFan() {

            @Override
            public void in() {
                System.out.println("Mi Light Fan is ON");
            }

            @Override
            public void off() {
                System.out.println("Mi Light Fan is OFF");
            }
        };
    }

    public IFan getMiSmartFan2() {
        return new IFan() {
            @Override
            public void in() {
                System.out.println("Mi Smart Fan 2 is ON");
            }

            @Override
            public void off() {
                System.out.println("Mi Smart Fan 2 is OFF");
            }
        };
    }
}
