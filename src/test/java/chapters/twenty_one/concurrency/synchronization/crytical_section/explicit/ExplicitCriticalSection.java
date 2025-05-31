package chapters.twenty_one.concurrency.synchronization.crytical_section.explicit;

import chapters.twenty_one.concurrency.synchronization.crytical_section.PairManager;
import chapters.twenty_one.concurrency.synchronization.crytical_section.CriticalSection;

public class ExplicitCriticalSection {
    public static void main(String[] args) {
        PairManager
                pm1 = new ExplicitPairManager1(),
                pm2 = new ExplicitPairManager2();

        CriticalSection.testApproaches(pm1, pm2);
    }
}
