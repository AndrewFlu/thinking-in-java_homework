package chapters.ten.anonymous.fans;

public class XiaomiFansTestDrive {
    public static void main(String[] args) {
        Xiaomi xiaomi = new Xiaomi();
        IFan miLightFan = xiaomi.getMiLightFan();
        IFan miSmartFan2 = xiaomi.getMiSmartFan2();

        miSmartFan2.in();
        miLightFan.in();
        miSmartFan2.off();
    }
}
