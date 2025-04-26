package net.mindview.atunit;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import net.mindview.utils.BinaryFile;
import net.mindview.utils.ProcessFiles;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import static net.mindview.utils.Print.print;

public class AtUnitRemover implements ProcessFiles.Strategy {

    private static boolean remove = false;

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-r")) {
            remove = true;
            String[] nargs = new String[args.length - 1];
            System.arraycopy(args, 1, nargs, 0, nargs.length);
            args = nargs;
        }
        new ProcessFiles(new AtUnitRemover(), "class").start(args);
    }

    @Override
    public void process(File file) {
        boolean modified = false;
        try {
            String cName = ClassNameFinder.thisClass(BinaryFile.read(file));
            if (!cName.contains("."))
                return; // Классы вне пакетов игнорируются
            ClassPool cPool = ClassPool.getDefault();
            CtClass ctClass = cPool.get(cName);
            for (CtMethod method : ctClass.getDeclaredMethods()) {
                MethodInfo mi = method.getMethodInfo();
                AnnotationsAttribute attr = (AnnotationsAttribute) mi.getAttribute(AnnotationsAttribute.visibleTag);
                if (attr == null)
                    continue;
                for (Annotation ann : attr.getAnnotations()) {
                    if (ann.getTypeName().startsWith("new.mindview.atunit")) {
                        print(ctClass.getName() + " " + ann);
                        if (remove) {
                            ctClass.removeMethod(method);
                            modified = true;
                        }
                    }
                }
            }
            // в этой версии поля не удаляются
            if (modified)
                ctClass.toBytecode(new DataOutputStream(new FileOutputStream(file)));
            ctClass.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
