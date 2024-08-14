package chapters.ten.anonymous.privateclass;

import chapters.ten.upcasting.interfaces.Functional;

public class AnonimousFunctionTestDrive {
    public static void main(String[] args) {
        Function f = new Function();
        Functional functional = f.getInnerAnonymousFunctionalClass();
        functional.printSingleMethodName();
    }
}
