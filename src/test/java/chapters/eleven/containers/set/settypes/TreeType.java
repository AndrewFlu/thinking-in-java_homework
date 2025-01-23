package chapters.eleven.containers.set.settypes;

public class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType arg) {
        return i < arg.i ? 1 : (arg.i == i ? 0 : -1);
    }
}
