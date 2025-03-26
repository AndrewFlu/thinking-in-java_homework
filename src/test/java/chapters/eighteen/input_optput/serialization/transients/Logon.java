package chapters.eighteen.input_optput.serialization.transients;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "Logon info: \n username: " + username +
                "\n date: " + date +
                "\n password: " + password;
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Logon user1 = new Logon("superUser", "SecretPassword");
        System.out.println("Logon user1 = " + user1);
        // serialize
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        out.writeObject(user1);
        out.close();
        // pause
        TimeUnit.SECONDS.sleep(5);
        // deserialize
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recovering object at " + new Date());
        user1 = (Logon) in.readObject();
        System.out.println("Logon restored user1 = " + user1);
    }
}
