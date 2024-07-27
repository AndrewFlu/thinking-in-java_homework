package chapters.seven.overloading;

public class OverloadingTestDrive {
    public static void main(String[] args) {
        Mfu mfu = new Mfu();

        mfu.print(1);
        mfu.print("Принтер");
        mfu.print('a');
        mfu.print(new char[] {'a', 'b', 'c'});
    }
}
