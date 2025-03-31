package chapters.nineteen.enums.categories.menu;

public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.BURRITO;
        food = Food.Desert.CREAM_CARAMEL;
        food = Food.Coffee.BLACK_COFFEE;
    }
}
