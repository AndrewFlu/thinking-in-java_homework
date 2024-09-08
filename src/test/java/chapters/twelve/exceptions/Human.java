package chapters.twelve.exceptions;

public class Human {
    public static void main(String[] args) {
        WrappedAnnoyanceException ex = new WrappedAnnoyanceException();
        try {
            ex.throwRte(1);
        } catch (RuntimeException e) {
            try {
                throw e.getCause();
            } catch (Sneeze s) {
                System.out.println("Перехвачен Sneeze: " + s);
            } catch (Annoyance a) {
                System.out.println("Перехвачен Annoyance: " + a);
            } catch (Throwable t) {
                System.out.println("Перехвачен Throwable: " + t);
            }
        }
    }
}

class Annoyance extends RuntimeException {}
class Sneeze extends Annoyance {}

class WrappedAnnoyanceException {
    void throwRte(int type) {
        try {
            switch (type) {
                case 0: throw new Annoyance();
                case 1: throw new Sneeze();
                default: return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
