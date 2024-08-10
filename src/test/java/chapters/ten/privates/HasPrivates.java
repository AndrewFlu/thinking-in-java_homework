package chapters.ten.privates;

public class HasPrivates {
    private String name = "Поле внешнего класса";

    private String getInfo() {
        return "This is a closed method in the HasPrivates class";
    }

    public void useInner() {
        HasPrivateInner hasPrivateInner = this.new HasPrivateInner();
        hasPrivateInner.changeOuterPrivateField();
    }

    public String getName() {
        return name;
    }

    public void printInnerInfo() {
        System.out.println(this.new HasPrivateInner().getInnerInfo());
    }

    class HasPrivateInner {
        private final String innerInfo = "Inner class info";

        private String getInnerInfo() {
            return innerInfo;
        }

        void changeOuterPrivateField() {
            name = "Поле внешнего класса изменено";
            System.out.println(getInfo());
        }
    }

}
