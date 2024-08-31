package chapters.twelve.exceptions.models;

public class RenewalModel {
    public static void main(String[] args) {
        String[] germanyCarBrands = {"Audi", "BMW", "Mercedes-Benz", "Volkswagen"};
        int startDescendingPosition = germanyCarBrands.length;
        boolean hasException = true;
        while (hasException) {
            try {
                String germanyCarBrand = germanyCarBrands[startDescendingPosition--];
                System.out.println(germanyCarBrand);
                hasException = false;
            } catch (ArrayIndexOutOfBoundsException exception) {
                hasException = true;
            }
        }
        System.out.println("за пределами while");
    }
}
