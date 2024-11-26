package chapters.fifteen.generics.covariants.homework;

public abstract class AbstractWebPage<T extends AbstractWebPage<T>> {
    T element;

    public AbstractWebPage(T element) {
        this.element = element;
    }

    abstract T waitAndGetPage(T page);

    T open() {
        System.out.println("The page is opened: " + element);
        return waitAndGetPage(element);
    }
}
