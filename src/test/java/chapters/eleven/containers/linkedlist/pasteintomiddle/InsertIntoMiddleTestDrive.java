package chapters.eleven.containers.linkedlist.pasteintomiddle;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class InsertIntoMiddleTestDrive {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        ListIterator<Integer> iterator;
        for (int i = 0; i < 8; i++) {
            int middleIndex = linkedList.size() / 2;
            iterator = linkedList.listIterator(middleIndex);

            iterator.add(getRandomInt());
        }

        System.out.println(linkedList);
    }

    private static int getRandomInt() {
        return rand.nextInt(10);
    }
}
