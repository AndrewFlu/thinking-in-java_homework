package chapters.twenty_one.concurrency.crytical_section.explicit;

import chapters.twenty_one.concurrency.crytical_section.CriticalSection;
import chapters.twenty_one.concurrency.crytical_section.PairManager;

public class ExplicitCriticalSection {
    public static void main(String[] args) {
        PairManager
                pm1 = new ExplicitPairManager1(),
                pm2 = new ExplicitPairManager2();

        CriticalSection.testApproaches(pm1, pm2);
    }
}
