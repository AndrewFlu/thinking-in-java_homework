package chapters.ten.nested;

public class Third {
    public static class SecondNested {
        public SecondNested() {
            System.out.println("Создание second nested класса");
        }

        public static class FirstNested {
            public FirstNested() {
                System.out.println("Создание first nested класса");
            }
        }
    }

    public static void main(String[] args) {
        SecondNested.FirstNested first = new SecondNested.FirstNested();
    }
}
