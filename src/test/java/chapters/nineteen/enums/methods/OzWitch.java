package chapters.nineteen.enums.methods;

public enum OzWitch {
    WEST("Miss Gulch, aka the Wicked Witch of the west"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's House"),
    SOUTH("Good by inference, but missing");

    private final String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
       for (OzWitch witch : values())
           System.out.println(witch + ": " + witch.getDescription());
    }
}
