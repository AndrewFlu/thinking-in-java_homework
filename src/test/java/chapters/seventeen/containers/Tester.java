package chapters.seventeen.containers;

import java.util.List;

// Применяет объекты Test к спискам разных контейнеров
public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParams = TestParam.array(
            10, 5000, 100, 5000, 1000, 5000, 10000, 500
    );

    // Переопределите этот метод, чтоды изменить предварительную инициализацию до выполнения теста:
    protected C initialise(int size) {
        return container;
    }

    protected C container;

    private String headLine = "";
    private List<Test<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;

    private static String sizeField = "%" + sizeWidth + "s";

    private TestParam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null)
            headLine = container.getClass().getSimpleName();
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHeadLine(String newHeadLine) {
        headLine = newHeadLine;
    }

    // Вспомогательные обобщённые методы:
    public static <C> void run(C cntnr, List<Test<C>> tests) {
        new Tester(cntnr, tests).timedTest();
    }

    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        new Tester(cntnr, tests, paramList).timedTest();
    }

    private void displayHeader() {
        // Вычислить ширину и дополнить "-"
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headLine.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++)
            head.append('-');
        head.append(' ');
        head.append(headLine);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++)
            head.append('-');
        System.out.println(head);
        // Вывести заголовки столбцов
        System.out.format(sizeField, "size");
        for (Test test : tests)
            System.out.format(stringField(), test.name);
        System.out.println();
    }

    // Выполнить тесты для текущего контейнера
    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                C container = initialise(param.size);
                long start = System.nanoTime();
                // Вызов переопределённого метода
                int reps = test.test(container, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps; // наносекунды
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
}
