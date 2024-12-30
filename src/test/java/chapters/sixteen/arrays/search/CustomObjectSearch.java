package chapters.sixteen.arrays.search;

import chapters.sixteen.arrays.comparing.CustomObject;
import chapters.sixteen.arrays.generators.Generated;
import chapters.sixteen.arrays.generators.RandomGenerator;

import java.util.Arrays;

public class CustomObjectSearch {
    public static void main(String[] args) {
        CustomObject[] customObjects = Generated.array(new CustomObject[10], new RandomGenerator.CustomObject());
        System.out.println("initial array: " + Arrays.toString(customObjects));
        CustomObject searchingObject = customObjects[8];
        System.out.println("Searching object: " + searchingObject);
        Arrays.sort(customObjects);
        System.out.println("after sorting: " + Arrays.toString(customObjects));

        int index = Arrays.binarySearch(customObjects, searchingObject);
        System.out.printf("The object [%s] is found on position %s into customObjects[]", searchingObject, index);
    }
}
