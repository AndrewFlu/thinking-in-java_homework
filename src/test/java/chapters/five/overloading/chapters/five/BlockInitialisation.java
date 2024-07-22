package chapters.five.overloading.chapters.five;

import chapters.three.StringComparison;

public class BlockInitialisation extends StringComparison {
    String label;
    {
        label = "object label";
        System.out.println("поле экземпляра проринициализировано!");
    }

    public static void main(String[] args) {
        BlockInitialisation bi = new BlockInitialisation();
        BlockInitialisation bi1 = new BlockInitialisation();
        System.out.println(bi.label);
        System.out.println(bi1.label);
        bi1.label = "new bi1 label";
        System.out.println(bi1.label);
    }
}
