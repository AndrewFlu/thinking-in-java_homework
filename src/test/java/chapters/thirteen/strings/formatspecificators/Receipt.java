package chapters.thirteen.strings.formatspecificators;

import java.util.Formatter;

public class Receipt {
    public static int BASE_WIDTH = 30;

    private static final int CENTER_WIDTH = BASE_WIDTH / 6;
    private static final int LEFT_BORDER_WIDTH = BASE_WIDTH / 2;
    private static final int RIGHT_BORDER_WIDTH = BASE_WIDTH / 3;

    private final Formatter f = new Formatter(System.out);
    private double total = 0;

    public void printTitle() {
        f.format("%-" + LEFT_BORDER_WIDTH + "s %" + CENTER_WIDTH + "s %" + RIGHT_BORDER_WIDTH + "s\n", "Item", "Qty", "Price");
        f.format("%-" + LEFT_BORDER_WIDTH + "s %" + CENTER_WIDTH + "s %" + RIGHT_BORDER_WIDTH + "s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format("%-" + LEFT_BORDER_WIDTH + "." + LEFT_BORDER_WIDTH + "s %"+ CENTER_WIDTH + "s %" + RIGHT_BORDER_WIDTH + ".2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%-" + LEFT_BORDER_WIDTH + "s %" + CENTER_WIDTH + "s %" + RIGHT_BORDER_WIDTH + ".2f\n", "Tax", "", total * 0.06);
        f.format("%-" + LEFT_BORDER_WIDTH + "s %" + CENTER_WIDTH + "s %" + RIGHT_BORDER_WIDTH + "s\n", "", "", "-----");
        f.format("%-" + LEFT_BORDER_WIDTH + "s %" + CENTER_WIDTH + "s %" + RIGHT_BORDER_WIDTH + ".2f\n", "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's magic beans", 4, 4.25);
        receipt.print("Princess Peas", 5, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
