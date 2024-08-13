package chapters.ten.locals.fans;

public class XiaomiFansTestDrive {
    public static void main(String[] args) {
        Xiaomi xiaomi = new Xiaomi();

        IFan miFan2 = xiaomi.getMiFan2();
        IFan miFanLight = xiaomi.getMiFanLight();

        miFan2.in();

        miFanLight.in();
        miFanLight.off();
    }
}
