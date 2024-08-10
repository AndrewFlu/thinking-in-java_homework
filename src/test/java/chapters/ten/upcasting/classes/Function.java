package chapters.ten.upcasting.classes;

import chapters.ten.upcasting.interfaces.Functional;

public class Function {
    protected class InnerFunctionalClass implements Functional {
        @Override
        public void printSingleMethodName() {
            System.out.println("Я защищённый внутренний класс Function.InnerFunctionalClass и метод printSingleMethodName()");
        }
    }


    public Functional fetInnerFunctionalClass() {
        return new InnerFunctionalClass();
    }
}
