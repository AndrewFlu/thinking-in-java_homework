package chapters.fifteen.generics.multipleinterface;

public class MultipleInterfaceVariants {

}

interface Payable {
}

class Employee implements Payable {
}

// не компилируется: стирание сокращает
//Payable<Employee> и Playable<Hourly> до одного класса Playable
// ! Но если убрать типизирование интерфейса, то код успешно компилируется

class Hourly extends Employee implements Payable {
}
