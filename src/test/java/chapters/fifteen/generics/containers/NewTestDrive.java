package chapters.fifteen.generics.containers;

import java.util.*;

public class NewTestDrive {
    public static void main(String[] args) {
        Map<String, List<String>> sls = New.map();
        List<String> ls = New.list();
        LinkedList<String> lls = New.lList();
        Set<Integer> si = New.set();
        Queue<Double> qd = New.queue();
    }
}
