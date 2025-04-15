package chapters.twenty.annotations.tracking;

import chapters.twenty.annotations.base_syntax.PasswordUtils;
import chapters.twenty.annotations.base_syntax.UseCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);

        trackUseCases(useCases, PasswordUtils.class);
    }

    private static void trackUseCases(List<Integer> useCases, Class<?> clazz) {
        for (Method m : clazz.getDeclaredMethods()) {
            UseCase useCase = m.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.println("Found Use Case: " + useCase.id() + " " + useCase.description());
                useCases.remove(Integer.valueOf(useCase.id()));
            }
        }

        for (int i : useCases)
            System.out.println("WARNING: Missing Use Case: " + i);
    }
}
