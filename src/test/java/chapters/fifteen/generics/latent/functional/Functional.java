package chapters.fifteen.generics.latent.functional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Functional {

    // Вызывает объект Combiner для каждого элемента, чтобы объединить его с накапливаемым результатом,
    // который в конечном итоге возвращается:
    public static <T> T reduce(Iterable<T> sequence, Combiner<T> combiner) {
        Iterator<T> iterator = sequence.iterator();
        if (iterator.hasNext()) {
            T result = iterator.next();
            while (iterator.hasNext()) {
                result = combiner.combine(result, iterator.next());
            }

            return result;
        }
        // если sequence — пустой список
        return null;
    }


    // Получает объект функции и вызывает его для каждого объекта
    // в списке, игнорируя возвращаемое значение. Объект функции
    // может действовать как параметр-накопитель,
    // поэтому он возвращается в конце:
    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq) {
            func.function(t);
        }

        return func;
    }

    // Создаёт список результатов, вызывая объект функции
    // для каждого объекта в списке:
    public static <R, T> List<R> transform(Iterable<T> sequence, UnaryFunction<R, T> function) {
        List<R> result = new ArrayList<>();
        for (T t : sequence) {
            result.add(function.function(t));
        }

        return result;
    }

    // Применяет унарный предикат к каждому элементу последовательности
    // и возвращает список элементов, для которых было получено значение true:
    public static <T> List<T> filter(Iterable<T> sequence, UnaryPredicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : sequence) {
            if (predicate.test(t)) result.add(t);
        }

        return result;
    }

    // Для использования приведённых выше обобщённых методов
    // необходимо создать объекты функций для их адаптации к нашим конкретным потребностям:
    static class IntegerAdder implements Combiner<Integer> {

        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class IntegerSubtracter implements Combiner<Integer> {

        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    static class BigDecimalAdder implements Combiner<BigDecimal> {

        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class BigIntegerAdder implements Combiner<BigInteger> {

        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class AtomicLongAdder implements Combiner<AtomicLong> {

        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            // неясно насколько это осмысленно
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {

        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GreaterThen<T extends Comparable<T>> implements UnaryPredicate<T> {
        private final T bound;

        public GreaterThen(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultyplyingIntegerCollector implements Collector<Integer> {
        private Integer value = 1;

        @Override
        public Integer result() {
            return value;
        }

        @Override
        public Integer function(Integer x) {
            value *= x;

            return value;
        }
    }

    // test-drive
    public static void main(String[] args) {
        // Обощения, списки аргументов переменной длны и упаковка работают совместно:
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer result = reduce(li, new IntegerAdder());
        System.out.println(result);

        result = reduce(li, new IntegerSubtracter());
        System.out.println(result);

        System.out.println(filter(li, new GreaterThen<Integer>(4)));

        System.out.println(forEach(li, new MultyplyingIntegerCollector()).result());

        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(
                new BigDecimal(1.1, mc),
                new BigDecimal(2.2, mc),
                new BigDecimal(3.3, mc),
                new BigDecimal(4.4, mc),
                new BigDecimal(5.5, mc)
        );
        BigDecimal rbd = reduce(lbd, new BigDecimalAdder());
        System.out.println(rbd);

        System.out.println(filter(lbd, new GreaterThen<>(new BigDecimal(3))));

        // Использование средств генерирования простых чисел BigInteger:
        List<BigInteger> lbi = new ArrayList<>();
        BigInteger bi = BigInteger.valueOf(11);
        for (int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        System.out.println(lbi);

        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        System.out.println(rbi);

        // Сумма этого списка простых чисел также является простым числом:
        System.out.println(rbi.isProbablePrime(5));

        List<AtomicLong> lal = Arrays.asList(
                new AtomicLong(11), new AtomicLong(47),
                new AtomicLong(74), new AtomicLong(133)
        );
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        System.out.println(ral);

        System.out.println(transform(lbd, new BigDecimalUlp()));
    }
}

