package chapters.eight.cycles;

public class Cycles {
    private static CycleGenerator cycleGenerator = new CycleGenerator();

    public static void main(String[] args) {
        Cycle cycles[] = new Cycle[5];
        for (int i = 0; i < cycles.length; i++) {
            cycles[i] = cycleGenerator.next();
        }

        for (Cycle cycle : cycles) {
            cycle.ride();
        }
    }
}
