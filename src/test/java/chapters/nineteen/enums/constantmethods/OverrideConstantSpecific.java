package chapters.nineteen.enums.constantmethods;

import static net.mindview.utils.Print.print;

public enum OverrideConstantSpecific {
    NUT,
    BOLT,
    WASHER{
        void f() {
            print("Overridden method");
        }
    },
    ;

    void f(){
        print("Default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific o : values()) {
            System.out.print(o + ": ");
            o.f();
        }
    }
}
