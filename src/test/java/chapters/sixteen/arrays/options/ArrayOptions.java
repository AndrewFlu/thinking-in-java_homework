package chapters.sixteen.arrays.options;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.Arrays;

import static net.mindview.utils.Print.print;

public class ArrayOptions {
    public static void main(String[] args) {
        // Массив объектов
        BerylliumSphere[] a; // Локальная инициализированная переменная
        BerylliumSphere[] b = new BerylliumSphere[5];
        // Ссфлки в массиве автоматически инициализируются null
        System.out.println("b: " + Arrays.toString(b));

        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            // Можно проверять ссылку на null
            if (c[i] == null) c[i] = new BerylliumSphere();
        }
        // Групповая инициализация
        BerylliumSphere[] d = {
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere()
        };
        // Динамическая групповая инициализация
        a = new BerylliumSphere[]{
                new BerylliumSphere(),
                new BerylliumSphere()
        };
        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);

        // Массивы примитивов
        int[] e; // Null ссылка
        int[] f = new int[5];
        // Примитивы в массиве автоматически инициализируются нулями
        print("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = {11, 47, 93};
        // Ошибка компиляции: переменная e не инициализирована
//        print("e.lenght = " + e.length );
        print("f.length = " + f.length);
        print("d.length = " + g.length);
        print("h.length = " + h.length);

        e = h;
        print("e.lenght = " + e.length);
        e = new int[]{5, 7};
        print("e.length = " + e.length);
    }

}
