package chapters.sixteen.arrays.generics;

import chapters.fifteen.generics.erasedtype.array.ArrayOfGeneric;

import java.util.ArrayList;

public class ArrayOfGenericType<T> {
    T[] array;

    public ArrayOfGenericType(int size) {
//        array = new T[size];  illegal
        array = (T[])new Object[size]; // некотролируемое предупреждение
    }

    // Недопустимо из-за стирания
//    public <U> U[] makeArray() {return new U[10];}
}
