package chapters.twelve.exceptions.restrictions;

public class StormyInning extends Inning implements Storm {

    // Можно добавлять новые исключения для конструкторов,
    // но тогда необходимо обработать и исключения базового конструтора
    public StormyInning() throws BaseBallException, RainedOut {
    }

    public StormyInning(String s) throws Foul, BaseBallException {
    }

    @Override // переопределённые методы могут возбуждать унаследованные исключения
    public void atBat() throws PopFoul {
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

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul popFoul) {
            System.out.println("Pop foul");
        } catch (RainedOut rainedOut) {
            System.out.println("Rained out");
        } catch (BaseBallException e) {
            System.out.println("Generic baseball exception");
        }

        // strike не возбуждается в унаследованной версии
        try {
            Inning i = new StormyInning();
            i.atBat();
            // необходимо перехватывать исключения из базовой версии метода
        } catch (Strike strike) {
            System.out.println("Strike");
        } catch (Foul foul) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseBallException e) {
            System.out.println("Общее исключение");
        }
    }
}
