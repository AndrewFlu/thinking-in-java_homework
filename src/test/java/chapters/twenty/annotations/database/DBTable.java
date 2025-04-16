package chapters.twenty.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // apply to classes
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    String name() default "";
}
