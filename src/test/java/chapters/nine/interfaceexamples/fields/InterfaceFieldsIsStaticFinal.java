package chapters.nine.interfaceexamples.fields;

public class InterfaceFieldsIsStaticFinal implements IFields {
    private final int counter = COUNT;


    @Override
    public String getDayOfWeekDescription() {
        return IFields.DAY_OF_WEEK;
    }

    public static void main(String[] args) {
        InterfaceFieldsIsStaticFinal ifields1 = new InterfaceFieldsIsStaticFinal();
        InterfaceFieldsIsStaticFinal ifields2 = new InterfaceFieldsIsStaticFinal();
        System.out.println(ifields1.getDayOfWeekDescription());
        System.out.println(ifields2.getDayOfWeekDescription());
        System.out.println("interface count - " + ifields1.counter);
        System.out.println("interface count - " + ifields2.counter);
    }
}
