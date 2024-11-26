package chapters.fifteen.generics.covariants.homework;

public class WelcomePage extends AbstractWebPage<WelcomePage>{

    public WelcomePage() {
        super(initPage());
    }

    private static WelcomePage initPage() {
        return new WelcomePage();
    }

    @Override
    WelcomePage waitAndGetPage(WelcomePage page) {
        return page;
    }
}
