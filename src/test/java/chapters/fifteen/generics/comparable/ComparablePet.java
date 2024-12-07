package chapters.fifteen.generics.comparable;

import chapters.forteen.typeinfo.pets.Pet;

public abstract class ComparablePet extends Pet implements Comparable<ComparablePet>{
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
