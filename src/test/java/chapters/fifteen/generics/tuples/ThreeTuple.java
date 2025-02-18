package chapters.fifteen.generics.tuples;

import java.util.Objects;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof ThreeTuple) &&
                this.first.equals(((ThreeTuple) o).first) &&
                this.second.equals(((ThreeTuple) o).second) &&
                this.third.equals(((ThreeTuple) o).third);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return 37 * result + third.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof ThreeTuple<?,?,?>))
            throw new ClassCastException();
        ThreeTuple t = (ThreeTuple) o;
        return (this.hashCode() - t.hashCode()) < 0 ? -1 :
                ((this.hashCode() - t.hashCode()) > 0 ? 1 : 0);
    }
}
