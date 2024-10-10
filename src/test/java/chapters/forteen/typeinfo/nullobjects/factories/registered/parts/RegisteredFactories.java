package chapters.forteen.typeinfo.nullobjects.factories.registered.parts;

public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(Detail.createRandom());
        }
    }
}

