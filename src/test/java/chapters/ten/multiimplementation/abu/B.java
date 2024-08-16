package chapters.ten.multiimplementation.abu;

public class B {
    private U[] uArray = new U[5];
    private int index = 0;

    void addU(U u) {
        if (index < uArray.length) {
            uArray[index++] = u;
        }
    }

    void resetArgumentInUArray(int index) {
        if (index >= 0 && index < uArray.length) {
            uArray[index] = null;
        }
    }

    void executeUArray() {
        for (int i = 0; i < uArray.length; i++) {
            if(uArray[i] != null) {
                uArray[i].first();
                uArray[i].second();
                uArray[i].third();
            }
        }
    }
}
