package chapters.fifteen.generics.strorycharacters.marvel.infinitywar;

import net.mindview.utils.Generator;

import java.util.Iterator;
import java.util.Random;

public class CharacterGenerator implements Generator<Character>, Iterable<Character> {
    private static int size;
    private final Random random = new Random();

    private final Class<?>[] characterTypes = {IronMan.class, Thor.class, Thanos.class, Rhonan.class};

    public CharacterGenerator(int desiredSize) {
        size = desiredSize;
    }

    public CharacterGenerator() {
    }

    @Override
    public Character next() {
        try {
            return (Character) characterTypes[random.nextInt(characterTypes.length)].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // iterable implementation
    @Override
    public Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    private class CharacterIterator implements Iterator<Character> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Character next() {
            count--;
            return CharacterGenerator.this.next();
        }
    }
}
