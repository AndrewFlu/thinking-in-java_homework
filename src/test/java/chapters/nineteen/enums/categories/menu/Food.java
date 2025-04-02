package chapters.nineteen.enums.categories.menu;

public interface Food {

    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUMMOUS, VINDALOO
    }

    enum Desert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREAM_CARAMEL
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA
    }

    enum Fruit implements Food {
        BANANA, ORANGE, APPLE, TANGERINE
    }

}
