package chapters.eighteen.input_optput.serialization.xml;

import net.mindview.containers.MapEntry;
import net.mindview.utils.TextFile;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

// Word count to XML
public class IOTask32 {
    public static void format(OutputStream os, Document doc) throws IOException {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(2);
        serializer.setMaxLength(64);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) {
        // File whose words are to be counted:
        String fileName = "src/test/java/chapters/eighteen/input_optput/serialization/xml/IOTask32.java";
        // Set of unique words in file:
        Set<String> uniqueWords = new TreeSet<>(new TextFile(fileName, "\\W+"));
        // List of all words in file:
        ArrayList<String> allWords = new TextFile(fileName, "\\W+");
        Map<String, Integer> wordCount = new TreeMap<>();
        for (String s : uniqueWords) {
            int count = 0;
            for (String w : allWords)
                if (w.equals(s)) count++;
            wordCount.put(s, count);
        }

        Element root = new Element("words"); // XML Root
        // Add Map data to XML Root:
        for (Map.Entry<String, Integer> me : wordCount.entrySet()) {
            Element word = new Element("word");
            word.appendChild(me.getKey() + ": ");
            word.appendChild(Integer.toString(me.getValue()));
            root.appendChild(word);
        }

        Document doc = new Document(root);

        try {
            format(System.out, doc);
            format(new BufferedOutputStream(new FileOutputStream("WordCount.xml")), doc);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
