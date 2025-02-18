package chapters.fifteen.generics.tuples;

public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D>{
    public final E fifth;
    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + forth + ", " + fifth + ")";
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof FiveTuple<?,?,?,?,?>) &&
                this.first.equals(((FiveTuple) o).first) &&
                this.second.equals(((FiveTuple) o).second) &&
                this.third.equals(((FiveTuple) o).third) &&
                this.forth.equals(((FiveTuple) o).forth) &&
                this.fifth.equals(((FiveTuple) o).fifth)
                ;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result * 37 + fifth.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof FiveTuple<?,?,?,?,?>))
            throw new ClassCastException();
        FiveTuple t = (FiveTuple) o;
        return (this.hashCode() - t.hashCode()) < 0 ? -1 :
                ((this.hashCode() - t.hashCode()) > 0 ? 1 : 0);
    }
}
