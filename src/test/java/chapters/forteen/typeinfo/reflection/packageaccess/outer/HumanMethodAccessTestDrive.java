package chapters.forteen.typeinfo.reflection.packageaccess.outer;

import chapters.forteen.typeinfo.reflection.packageaccess.library.Human;
import chapters.forteen.typeinfo.reflection.packageaccess.library.InnerLibraryClass;

public class HumanMethodAccessTestDrive {
    public static void main(String[] args) {
        Human yuran = new Human("Юран", 250000);
        yuran.sayName();

        Human zhenya = new Human("Женя", 300000);
        Woman anna = new Woman("Аня", zhenya);
        zhenya.sayName();
        anna.sayName();
        anna.printProtectedMethodInfo();

        InnerLibraryClass inner = new InnerLibraryClass();
        inner.printHumanPackagePrivateMethodInfo(zhenya);
    }
}
