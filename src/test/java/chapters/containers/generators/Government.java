package chapters.containers.generators;

import utils.Generator;

public class Government implements Generator<String> {
    private int index;
    String[] foundation = "I love Motorcycles! And my favorite bike is Yamaha Raider!".split(" ");

    @Override
    public String next() {
        return foundation[index++];
    }
}
