package chapters.ten.interfaces.runners;

public class RunnerTestDrive {
    public static void main(String[] args) {
        IRunner marathonist = new IRunner.Marathonist();
        marathonist.run();
    }
}
