package chapters.fifteen.generics.latent.reflection;

import java.lang.reflect.Method;

import static net.midview.Print.print;

public class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> speakerClass = speaker.getClass();
        try {

            try {
                Method speak = speakerClass.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException ex) {
                print(speaker + " cannot speak");
            }

            try {
                Method sit = speakerClass.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException ex) {
                print(speaker + " cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}
