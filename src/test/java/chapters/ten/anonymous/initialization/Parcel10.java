package chapters.ten.anonymous.initialization;

public class Parcel10 {
    public Destination destination(String dest, float price) {
        return new Destination() {
            private final String label = dest;
            private final int cost;
            // инициализация экземпляра для каждого объекта
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println(String.format("Посылка в %s: Превышение бюджета!", readLabel()));
                }
            }

            @Override
            public String readLabel() {
                return label;
            }
        };
    }
}
