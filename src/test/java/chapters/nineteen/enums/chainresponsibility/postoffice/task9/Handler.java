package chapters.nineteen.enums.chainresponsibility.postoffice.task9;

public interface Handler {
    boolean handle(Mail9 mail); // Command design pattern
}
