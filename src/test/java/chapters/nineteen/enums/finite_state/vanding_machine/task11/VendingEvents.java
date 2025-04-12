package chapters.nineteen.enums.finite_state.vanding_machine.task11;

public class VendingEvents implements VendingInput {
    private String name;

    public VendingEvents(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
