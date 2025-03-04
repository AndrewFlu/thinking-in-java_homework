package chapters.eleven.containers.map.slowmap;

import chapters.eleven.containers.map.Maps;

public class SlowMapTest {
    public static void main(String[] args) {
        Maps.test(new SlowMap<>());
        Maps.test(new CorrectedSlowMap<>());
        Maps.test(new SlowMapWithOneArray<>());
    }
}
