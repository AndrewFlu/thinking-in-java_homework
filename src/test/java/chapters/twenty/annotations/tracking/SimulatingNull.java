package chapters.twenty.annotations.tracking;

public @interface SimulatingNull {
    public int id() default -1;
    public String description() default "";
}
