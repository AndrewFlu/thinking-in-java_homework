package chapters.twelve.exceptions.lostexception.byreturn;

public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            // использование return в блоке finally подавляет любое возбужденное исключение
            return;
        }
    }
}
