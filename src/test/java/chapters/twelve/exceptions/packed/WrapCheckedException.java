package chapters.twelve.exceptions.packed;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0: throw new FileNotFoundException();
                case 1: throw new IOException();
                case 2: throw new RuntimeException("RTE: где я?");
                default: return;
            }
        } catch (Exception e) { // превращаем в неконтролируемое
            throw new RuntimeException(e);
        }
    }
}
