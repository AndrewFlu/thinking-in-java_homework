package chapters.nineteen.enums.constantmethods.notclasses;

public enum LikeClasses {
    WINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior 1");
        }
    },
    BLINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior 2");
        }
    },
    NOD {
        @Override
        void behavior() {
            System.out.println("Behavior 3");
        }
    },
    ;

    abstract void behavior();
}
