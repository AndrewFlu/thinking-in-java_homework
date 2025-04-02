package chapters.nineteen.enums.categories.menu;

import net.mindview.utils.Enums;

public enum Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Desert.class),
    COFFEE(Food.Coffee.class),
    FRUITS(Food.Fruits.class),
    ;

    private Food[] values;

    Meal2(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public interface Food {
        enum Appetizer implements Food {SALAD, SOUP, SPRING_ROLLS}

        enum MainCourse implements Food {LASAGNE, BURRITO, pAD_THAI, LENTILS, HUMMOUS, VINDALOO}

        enum Desert implements Food {TIRAMISU, GElATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL}

        enum Coffee implements Food {BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA}

        enum Fruits implements Food {ORANGE, APPLE, TANGERINE, BANANA, PEAR}
    }

    public Food randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Meal2 meal : Meal2.values()) {
                Food food = meal.randomSelection();
                System.out.println(food);
            }
            System.out.println("-----------------");
        }
    }
}
