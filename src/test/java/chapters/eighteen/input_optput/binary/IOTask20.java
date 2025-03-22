package chapters.eighteen.input_optput.binary;

import net.mindview.utils.BinaryFile;
import net.mindview.utils.Directory;

import java.io.File;
import java.io.IOException;

public class IOTask20 {
    public static void main(String[] args) throws IOException {
        Directory.TreeInfo treeInfo = Directory.walk(".", ".*\\.class");
        for (File file : treeInfo) {
            System.out.println(file.getName());
            System.out.println(isValidClassSignature(BinaryFile.read(file)));
        }

    }

    private static boolean isValidClassSignature(byte[] fileBytes) {
        if (fileBytes.length < 4)
            System.out.println("Incorrect class");

        return fileBytes[0] == (byte) 202
                && fileBytes[1] == (byte) 254
                && fileBytes[2] == (byte) 186
                && fileBytes[3] == (byte) 190
                ;
    }
}
