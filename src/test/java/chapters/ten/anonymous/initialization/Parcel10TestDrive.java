package chapters.ten.anonymous.initialization;

public class Parcel10TestDrive {
    public static void main(String[] args) {
        Parcel10 parcel = new Parcel10();

        Destination austria = parcel.destination("Австрия", 90);
        Destination usa = parcel.destination("USA", 130.89F);
        System.out.println(austria.readLabel());
        System.out.println(usa.readLabel());
    }
}
