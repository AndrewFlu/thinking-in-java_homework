package chapters.fifteen.generics.erasedtype;

public class PortablePcUtility {
    public static <T extends IPortablePc> void chargePc(T portablePc) {
        portablePc.charge();
    }

    // test-drive
    public static void main(String[] args) {
        MacBook macBook = new MacBook();

        macBook.watchVideo();
        chargePc(macBook);
        macBook.watchVideo();

    }
}
