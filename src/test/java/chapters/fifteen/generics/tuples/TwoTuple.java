package chapters.fifteen.generics.tuples;

import chapters.fifteen.generics.tuples.inferedtypes.Tuple;

public class TwoTuple <A,B> implements Comparable{
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        return
                o instanceof TwoTuple &&
                        (first.equals(((TwoTuple) o).first)) &&
                        (second.equals(((TwoTuple) o).second));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + first.hashCode();
        result = result * 37 + second.hashCode();

        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof TwoTuple<?,?>))
            throw new ClassCastException();
        TwoTuple t = (TwoTuple) o;

        return (this.hashCode() - t.hashCode()) < 0 ? -1 :
                ((this.hashCode() - t.hashCode()) > 0 ? 1 : 0);
    }
}
