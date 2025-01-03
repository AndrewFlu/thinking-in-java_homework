package chapters.containers.generators;

import chapters.sixteen.arrays.generators.RandomGenerator;

import java.util.ArrayList;

public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList<String>(CollectionData.list(new RandomGenerator.String(3), 5)));
    }
}
