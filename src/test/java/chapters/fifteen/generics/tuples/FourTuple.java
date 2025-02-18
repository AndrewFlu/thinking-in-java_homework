package chapters.fifteen.generics.tuples;

import java.util.Objects;

public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D forth;


    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        forth = d;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + forth + ")";
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof FourTuple<?,?,?,?>) &&
                this.first.equals(((FourTuple) o).first) &&
                this.second.equals(((FourTuple) o).second) &&
                this.third.equals(((FourTuple) o).third) &&
                this.forth.equals(((FourTuple) o).forth)
                ;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result * 37 + forth.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof FourTuple<?,?,?,?>))
            throw new ClassCastException();
        FourTuple t = (FourTuple) o;
        return (this.hashCode() - t.hashCode()) < 0 ? -1 :
                ((this.hashCode() - t.hashCode()) > 0 ? 1 : 0);
    }
}
