package chapters.nine.interfaceexamples.other;

import chapters.nine.interfaceexamples.inner.PrepareCompetition;

public class RunCompetition implements PrepareCompetition {
    @Override
    public void ready() {
        System.out.println("Бегуны! На старт, ...");
    }

    @Override
    public void steady() {
        System.out.println("Внимание...");
    }

    @Override
    public void go() {
        System.out.println("Марш!!!");
    }

    public static void main(String[] args) {
        RunCompetition run = new RunCompetition();
        run.ready();
        run.steady();
        run.go();
    }
}
