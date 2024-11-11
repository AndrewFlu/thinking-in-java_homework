package chapters.fifteen.generics.covariants.fruits;

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[7];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        // Тип времени выполнения — Apple[], а не Fruit[] или Orange[]
        try {
            // компилятор позволяет добавить Fruit
            fruits[2] = new Fruit(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // компилятор позволяет добавить Orange
            fruits[3] = new Orange();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

