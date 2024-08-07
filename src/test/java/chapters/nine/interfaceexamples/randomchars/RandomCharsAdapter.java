package chapters.nine.interfaceexamples.randomchars;

import java.io.IOException;
import java.nio.CharBuffer;

public class RandomCharsAdapter extends RandomChars implements Readable {
    private int count;

    public RandomCharsAdapter(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }
        char randomChar = getSingleRandomChar();
        cb.append(randomChar);

        return count;
    }
}
