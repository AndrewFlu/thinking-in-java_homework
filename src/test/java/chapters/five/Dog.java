package chapters.five;

import static net.mindview.utils.Print.print;

public class Dog {

    public static void main(String[] args) {
        Dog ponchik = new Dog();

        ponchik.bark();
        ponchik.bark((byte) 2);
        ponchik.bark('c');
        ponchik.bark((short) 3);
        ponchik.bark(5);
        ponchik.bark(5L);
        ponchik.bark(5.1f);
        ponchik.bark(5.2);
    }

    void bark() {
        print("Дефолтный лай");
    }

    void bark(byte b) {
        print("Лай, размером " + b + " байт");
    }

    void bark(char ch) {
        print("Лай, начинающийся с буквы " + ch);
    }

    void bark(short sh) {
        print("Короткий лай " + sh);
    }

    void bark(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("bark ");
        }
        print("");
    }

    void bark(long l) {
        print("Длинный лай " + l);
    }

    void bark(float f) {
        print("Плавающий лай " + f);
    }

    void bark(double d) {
        print("Двойной плавающий лай " + d);
    }
}
