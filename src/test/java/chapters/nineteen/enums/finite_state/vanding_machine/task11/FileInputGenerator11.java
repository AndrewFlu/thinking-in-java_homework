package chapters.nineteen.enums.finite_state.vanding_machine.task11;

import net.mindview.utils.Generator;
import net.mindview.utils.TextFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FileInputGenerator11 implements Generator<VendingInput> {
    private final ArrayList<String> list;
    private final List<VendingInput> vendList = new ArrayList<VendingInput>();
    private final Iterator<VendingInput> it;
    private final Random rand = new Random();
    private final Iterator<String> input = new TextFile("src/test/java/chapters/nineteen/enums/finite_state/vanding_machine/task11/VendingMachineInput11.txt", ";").iterator();

    // Construct List of VendingInput from appropriately formatted txt file:
    public FileInputGenerator11(String fileName) {
        list = new TextFile(fileName, ",|;|:");
        int money = list.indexOf("Money");
        int selection = list.indexOf("Selection");
        int event = list.indexOf("VendingEvent");
        VendingInput vIn;
        for (String s : list) {
            int x = list.indexOf(s);
            if (money < x && x < selection) {
                String[] sa = s.split("[()]");
                vIn = new MonetaryUnit(sa[0], Integer.parseInt(sa[1]));
                vendList.add(vIn);
            } else if (selection < x && x < event) {
                String[] sa = s.split("[()]");
                vIn = new VendedItem(sa[0], Integer.parseInt(sa[1]));
                vendList.add(vIn);
            } else if (event < x) {
                vIn = new VendingEvents(s);
                vendList.add(vIn);
            }
        }
        it = vendList.iterator();
    }

    @Override
    public VendingInput next() {
        if (list.isEmpty()) return null;
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public VendingInput randomNext() {
        return vendList.get(rand.nextInt(vendList.size()));
    }

    public VendingInput textExampleNext(String fileName) {
        if (!input.hasNext()) return null;
        String s = input.next().trim();
        String s1 = s.charAt(0) + s.substring(1).toLowerCase();
        for (VendingInput vendingInput : this.vendList) {
            if (vendingInput.getName().equals(s1)) {
                return vendingInput;
            }
        }
        return null;
    }
}
