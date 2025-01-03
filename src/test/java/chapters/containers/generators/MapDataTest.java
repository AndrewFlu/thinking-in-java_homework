package chapters.containers.generators;

import chapters.sixteen.arrays.generators.CountingGenerator;
import chapters.sixteen.arrays.generators.RandomGenerator;

import static net.midview.Print.print;

public class MapDataTest {
    public static void main(String[] args) {
        // Генератор Pair<>
        System.out.println(MapData.map(new Letters(), 11));
        // Два разных генератора
        System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(5), 10));
        // Генератор ключей и одно значение
        System.out.println(MapData.map(new CountingGenerator.Character(), "MacBook", 5));
        // Iterable и генератор значений
        System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
        // Iterable и одно значение
        System.out.println(MapData.map(new Letters(), "MacBook"));
    }
}
