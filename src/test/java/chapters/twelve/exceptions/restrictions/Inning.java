package chapters.twelve.exceptions.restrictions;

public abstract class Inning {
    public Inning() throws BaseBallException {
    }

    public void event() throws BaseBallException {
        // фактически возбуждать исключение не нужно
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
        // не возбуждает контролируемых исключений
    }
}
