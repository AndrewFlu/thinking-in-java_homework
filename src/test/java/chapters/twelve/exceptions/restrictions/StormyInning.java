package chapters.twelve.exceptions.restrictions;

public class StormyInning extends Inning implements Storm {

    public StormyInning() {
    }

    public StormyInning(String s) {
    }

    @Override
    public void atBat() {
    }

    @Override // Можно не возбуждать исключений вообще, даже если базовая версия метода это делает
    public void event() {
    }

    // методы, которые не специфицированы исключением в базовом классе
    // не могут специфицироваться никаким исключением в дочерних, переопределённых версиях
//    public void walk() throws PopFoul{
//    }

    // интерфейс НЕ МОЖЕТ добавлять исключения к существующим методам базового класса
//    public void event() throws RainedOut {}

    // если метод не был определён в базовом классе — исключения допускаются
    public void rainedHard() throws RainedOut {
    }

    @Override
    public void pitch() {
        super.pitch();
    }

    public static void main(String[] args) {
        StormyInning si = new StormyInning();
        si.atBat();
        si.pitch();

        Inning i = new StormyInning();
        i.atBat();
    }
}
