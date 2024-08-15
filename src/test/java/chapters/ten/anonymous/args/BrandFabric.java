package chapters.ten.anonymous.args;

public class BrandFabric {
    public static Brand createBrand(String name) {
        return new Brand(name);
    }

    public static void main(String[] args) {
        Brand cK = createBrand("Calvin Klein");
        Brand apple = createBrand("Apple");
        System.out.println(cK.getName());
        System.out.println(apple.getName());
    }
}
