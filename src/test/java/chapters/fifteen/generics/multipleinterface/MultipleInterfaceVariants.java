package chapters.fifteen.generics.multipleinterface;

import chapters.nine.interfaceexamples.music.Playable;

public class MultipleInterfaceVariants {

}

interface Payable<T> {}

class Employee implements Payable<Employee> {}

// не компилируется: стирание сокращает
//Payable<Employee> и Playable<Hourly> до одного класса Playable

//class Hourly extends Employee implements Payable<Hourly> {}
