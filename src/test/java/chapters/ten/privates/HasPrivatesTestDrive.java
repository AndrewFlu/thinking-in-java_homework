package chapters.ten.privates;

public class HasPrivatesTestDrive {
    public static void main(String[] args) {
        HasPrivates privates = new HasPrivates();
        System.out.println(privates.getName());

        privates.useInner();

        System.out.println(privates.getName());

        privates.printInnerInfo();
    }
}
