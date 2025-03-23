package chapters.eighteen.input_optput.manageprocesses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSExecute {
    public static void command(String command) {
        boolean error = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;
            while ((s = results.readLine()) != null)
                System.out.println(s);

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            // Оповещение об ошибках и возврат ненулевого значения
            // вызывающему процессу при возникновении проблем
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                error = true;
            }
        } catch (Exception e) {
            // Для системы Windows 2000, которая выдаёт исключение
            // для командной строки по умолчанию:
            if (command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if (error)
            throw new OSExecuteException("Errors executing " + command);
    }
}
