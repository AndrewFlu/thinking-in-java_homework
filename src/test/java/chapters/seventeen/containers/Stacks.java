package chapters.seventeen.containers;

import java.time.Month;
import java.util.LinkedList;
import java.util.Stack;

import static net.midview.Print.print;

public class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (Month m : Month.values())
            stack.push(m.toString());
        System.out.println("stack = " + stack);
        // Работа со стеком как с Vector
        stack.addElement("The last line");
        print("element 5 = " + stack.elementAt(5));
        print("Popping elements: ...");
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.println();

        // Использование  LinkedList как стека
        LinkedList<String> lstack = new LinkedList<>();
        for (Month m : Month.values())
            lstack.addFirst(m.toString());
        print("lstack  = " + lstack);
        while (!lstack.isEmpty())
            System.out.print(lstack.removeFirst() + " ");
        System.out.println();

        // Использование класса Stack из главы 11
        chapters.eleven.containers.stack.Stack<String> stack2 = new chapters.eleven.containers.stack.Stack<>();
        for (Month m : Month.values())
            stack2.push(m.toString());
        print("stack2 = " + stack2);
        while (!stack2.isEmpty())
            System.out.print(stack2.pop() + " ");
        System.out.println();
    }
}
