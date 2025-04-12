package chapters.nineteen.enums.finite_state.vanding_machine.task11;

public class MonetaryUnit implements VendingInput {

    private String name;
    private int amount = 0;

    public MonetaryUnit(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String getName() {
        return name;
    }
}
