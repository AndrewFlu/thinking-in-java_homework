package chapters.eleven.containers.set.sortedset;

import chapters.containers.generators.CollectionData;
import chapters.containers.generators.CollectionDataGeneration;
import chapters.sixteen.arrays.generators.RandomGenerator;

import java.util.Collection;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTestDrive {
    public static void main(String[] args) {
        SortedSet<String> randomSortedSet = new TreeSet<>();
        String[] randomStrings = CollectionData.list(new RandomGenerator.String(5), 10).toArray(new String[0]);
        Collections.addAll(randomSortedSet, randomStrings);

        System.out.println(randomSortedSet);
    }
}
