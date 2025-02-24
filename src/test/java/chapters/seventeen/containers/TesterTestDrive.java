package chapters.seventeen.containers;

import java.util.List;

public class TesterTestDrive {
    public static void main(String[] args) {
        List<Test> tests = List.of(new Test("HD") {
            @Override
            int test(Object container, TestParam tp) {
                return tp.size;
            }
        });
        Tester tester = new Tester(List.of("Hello", "Andrew"), tests);
        tester.timedTest();
    }
}
