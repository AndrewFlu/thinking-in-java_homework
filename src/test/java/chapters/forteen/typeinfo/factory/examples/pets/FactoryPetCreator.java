package chapters.forteen.typeinfo.factory.examples.pets;

import chapters.forteen.typeinfo.pets.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FactoryPetCreator extends PetCreator {
    private static Random rand = new Random(47);
    private static List<IFactory<? extends Pet>> petFactories = Arrays.asList(
            new Mutt.Factory(),
            new Pug.Factory(),
            new EgyptianMau.Factory(),
            new Cymric.Factory(),
            new Rat.Factory(),
            new Hamster.Factory()
    );

    @Override
    public Pet randomPet() {
        int n = rand.nextInt(petFactories.size());
        return petFactories.get(n).create();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        throw new UnsupportedOperationException();
    }
}

class Cymric extends Manx {
    static class Factory implements IFactory<Cymric> {

        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
}

class Mutt extends Dog {
    public static class Factory implements IFactory<Mutt> {

        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
}

class Pug extends Dog {
    public static class Factory implements IFactory<Pug> {

        @Override
        public Pug create() {
            return new Pug();
        }
    }
}

class EgyptianMau extends Cat {
    public static class Factory implements IFactory<EgyptianMau> {
        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
}

class Rat extends Rodent {
    public static class Factory implements IFactory<Rat> {

        @Override
        public Rat create() {
            return new Rat();
        }
    }
}

class Hamster extends Rodent {
    public static class Factory implements IFactory<Hamster> {

        @Override
        public Hamster create() {
            return new Hamster();
        }
    }
}

class Manx extends Cat {
    public static class Factory implements IFactory<Manx> {

        @Override
        public Manx create() {
            return new Manx();
        }
    }
}