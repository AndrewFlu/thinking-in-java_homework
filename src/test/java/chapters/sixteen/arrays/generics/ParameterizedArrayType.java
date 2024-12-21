package chapters.sixteen.arrays.generics;

public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};

        Integer[] ints2 = new ClassParameter<Integer>().function(ints);
        Double[] doubles2 = new ClassParameter<Double>().function(doubles);

        ints2 = MethodParameter.function(ints);
        doubles2 = MethodParameter.function(doubles);
    }
}
