package chapters.fifteen.generics.tuples;

public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E>{
    public final F sixth;

    public SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        sixth = f;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + forth + ", " + fifth + ", " +sixth + ")";
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof SixTuple<?,?,?,?,?,?>) &&
                this.first.equals(((SixTuple) o).first) &&
                this.second.equals(((SixTuple) o).second) &&
                this.third.equals(((SixTuple) o).third) &&
                this.forth.equals(((SixTuple) o).forth) &&
                this.fifth.equals(((SixTuple) o).fifth) &&
                this.sixth.equals(((SixTuple) o).sixth)
                ;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result * 37 + fifth.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof SixTuple<?,?,?,?,?,?>))
            throw new ClassCastException();
        SixTuple t = (SixTuple) o;
        return (this.hashCode() - t.hashCode()) < 0 ? -1 :
                ((this.hashCode() - t.hashCode()) > 0 ? 1 : 0);
    }
}
