package chapters.forteen.typeinfo.interfaceviolation.packageaccess;

import chapters.forteen.typeinfo.interfaceviolation.A;

public class HiddenC {
    public static A makeA() {
        return new C();
    }
}
