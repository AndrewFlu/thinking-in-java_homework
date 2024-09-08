package chapters.twelve.exceptions.packed;

import java.io.FileNotFoundException;
import java.io.IOException;

import static net.midview.Print.print;

public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wrapCheckedException = new WrapCheckedException();
        wrapCheckedException.throwRuntimeException(5);

        for (int i = 0; i < 4; i++) {
            try {
                if(i < 3) {
                    wrapCheckedException.throwRuntimeException(i);
                } else {
                    throw new SomeOtherException();
                }
            } catch (SomeOtherException e) {
                print("SomeOtherException: " + e);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (FileNotFoundException ex) {
                    print("FileNotFoundException: " + ex);
                } catch (IOException ex) {
                    print("IOException: " + ex);
                } catch (Throwable ex) {
                    print("Throwable: " + ex);
                }
            }
        }
    }
}
