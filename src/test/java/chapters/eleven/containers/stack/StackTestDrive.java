package chapters.eleven.containers.stack;

public class StackTestDrive {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s : "MacBook is awesome!".split(" ")) {
            stack.push(s);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
