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

    class HasPrivateInner {
        void changeOuterPrivateField() {
            name = "Поле внешнего класса изменено";
            System.out.println(getInfo());
        }
    }

}
