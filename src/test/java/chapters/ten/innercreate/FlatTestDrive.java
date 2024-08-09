package chapters.ten.innercreate;

public class FlatTestDrive {
    public static void main(String[] args) {
        Flat eightyFive =  new Flat(85);
        Flat.BathRoom bathRoom = eightyFive.new BathRoom();
        bathRoom.setUnited(true);

        System.out.printf("В квартире № %s санузел совмещенный? — %s%n", eightyFive.getId(), bathRoom.isUnited());
    }
}
