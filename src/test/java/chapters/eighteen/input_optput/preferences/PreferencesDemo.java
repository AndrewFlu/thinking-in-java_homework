package chapters.eighteen.input_optput.preferences;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "Oz country");
        prefs.put("FootWear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are where Lion?", true);

        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);

        for (String key : prefs.keys())
            System.out.println(key + ": " + prefs.get(key, null));
        // Всегда необходимо предоставлять значение по умолчанию
        System.out.println("How many companions does Dorothy have? " + prefs.getInt("Companions", 0));
    }
}
