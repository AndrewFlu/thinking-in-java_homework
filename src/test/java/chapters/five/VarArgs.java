package chapters.five;

import static net.mindview.utils.Print.print;

public class VarArgs {
    public void printArgs(String... args) {
        for (String s : args) {
            print("argument in method — " + s);
        }
    }

    public static void main(String[] args) {
        VarArgs varArgs = new VarArgs();
        varArgs.printArgs("MacBook", "is", "awesome", "!");
        varArgs.printArgs(new String[] {"m1"});
        varArgs.printArgs(" ");
        varArgs.printArgs();
    }
}
