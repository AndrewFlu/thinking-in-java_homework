package chapters.forteen.typeinfo.generic;

import java.util.ArrayList;
import java.util.List;

public class FilledList<T> {
    private final Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<>(CountedInteger.class);
        System.out.println(fl.create(10));
    }
}
