package chapters.ten.innercreate;

public class Parcel {
    class Contents {
        private int i = 11;
        private int value() {
            return i;
        }
    }

    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Contents contents = parcel.new Contents();
        Destination receiverAddress = parcel.new Destination("receiver address");

        System.out.println("contents = " + contents.value());
        System.out.println("address = " + receiverAddress.readLabel());
    }
}
