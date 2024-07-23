package chapters.six;

import chapters.six.innerpackage.ClassInPackage;

public class OuterClass {
    ClassInPackage inner = new ClassInPackage();

    public OuterClass() {
        System.out.println("Инициализация экземпляра " + getClass().getSimpleName() + " в пакете 'chapters'");
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
    }
}
