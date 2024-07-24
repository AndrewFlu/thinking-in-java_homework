package chapters.six.packageprivate;

public class InnerClient {
    public static void main(String[] args) {
        new BasePrint().printString("Вызов из того же пакета");
    }
}
