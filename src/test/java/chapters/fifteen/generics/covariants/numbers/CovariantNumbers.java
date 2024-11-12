package chapters.fifteen.generics.covariants.numbers;

import java.util.Arrays;

public class CovariantNumbers {
    public static void main(String[] args) {
        Number[] numberArray = new Integer[5];
        numberArray[0] = new Integer(5); // принимает, т.к. созданный масив имеет тип Integer
        numberArray[1] = new Double(10.5); // не принимает (ошибка времени выполнения), т.к. Double != Integer
        // хоть и наследуют Number

        System.out.println(Arrays.toString(numberArray));
    }
}
