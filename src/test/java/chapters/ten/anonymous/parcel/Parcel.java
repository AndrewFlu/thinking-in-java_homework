package chapters.ten.anonymous.parcel;

public class Parcel {

    public Contents contents() {
        return new Contents() {
            public final int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel p = new Parcel();
        Contents c = p.contents();
        System.out.println(c.value());
    }
}
