package chapters.eleven.containers.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static chapters.eleven.containers.queue.QueueDemo.printQ;

public class ClassWithNoMembers {

}

class TestDrive {
    public static void main(String[] args) {
        List<ClassWithNoMembers> list = Arrays.asList(new ClassWithNoMembers(), new ClassWithNoMembers(), new ClassWithNoMembers());

        PriorityQueue<ClassWithNoMembers> classWithNoMembersPq = new PriorityQueue<>();
        classWithNoMembersPq.addAll(list);

        printQ(classWithNoMembersPq);
    }
}
