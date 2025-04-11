package chapters.nineteen.enums.finite_state.vanding_machine.taks10;

import chapters.nineteen.enums.finite_state.Input;

// Чтобы использовать паттерн Команда
public interface Command {
    void next(Input input);

    void next();
}