package chapters.eighteen.input_optput.serialization.xml;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Person {
    private String first, last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    // Создание объекта XML по объекту Person:
    public Element getXml() {
        Element person = new Element("Person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        person.appendChild(firstName);
        person.appendChild(lastName);

        return person;
    }

    // Конструктор для восстановления Person из объекта XML Element
    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }

    public String toString() {
        return first + " " + last;
    }

    // Преобразование в удобочитаемую форму:
    public static void format(OutputStream os, Document doc) throws Exception {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(
                new Person("Juran", "The Beardyman"),
                new Person("Zhenya", "The Designer"),
                new Person("Yana", "The Zhopka")
        );
        System.out.println(people);
        Element root  = new Element("people");
        for (Person p : people)
            root.appendChild(p.getXml());
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream("People.xml")), doc);
    }
}
