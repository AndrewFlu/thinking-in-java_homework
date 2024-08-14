package chapters.ten.anonymous.privateclass;

import chapters.ten.upcasting.interfaces.Functional;

public class Function {

    public Functional getInnerAnonymousFunctionalClass() {
        return new Functional() {
            @Override
            public void printSingleMethodName() {
                System.out.println("Я анонимный внутренний класс типа Functional и его внутренний метод printSingleMethodName()");
            }
        };
    }
}
