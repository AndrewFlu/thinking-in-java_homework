package chapters.five.overloading.chapters.five.sto;

import static net.midview.Print.print;

public class TechnicalCenter {
    public boolean repair(Car car) {
        boolean canRepair = diagnose(car);
        if (canRepair) {
            fix(car);
            return true;
        } else {
            return false;
        }
    }

    private void fix(Car car) {
        car.setHealth(true);
        print(String.format("Мы успешно починили ваш %s! Счастливого пути без поломок!\n", car.getBrand()));
    }

    private boolean diagnose(Car car) {
        if (isNeedRepair(car)) {
            print(String.format("Действительно, ваш автомобиль %s нуждается в ремонте!", car.getBrand()));
            return true;
        } else {
            print(String.format("Ваш %s полностью исправен и не нуждается в ремонте\n", car.getBrand()));
            return false;
        }
    }

    private boolean isNeedRepair(Car car) {
        return !car.getHealth();
    }
}