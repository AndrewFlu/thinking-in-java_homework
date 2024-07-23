package chapters.six.innerpackage;

public class ClassInPackage {
    public ClassInPackage() {
        System.out.println("Инициализация экземпляра " + getClass().getSimpleName() + " в пакете 'chapters.six.innerpackage'");
    }
}
