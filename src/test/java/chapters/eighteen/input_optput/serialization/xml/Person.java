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
    private String first, last, address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;

    }

    // Создание объекта XML по объекту Person:
    public Element getXml() {
        Element person = new Element("Person");
        Element firstNameElement = new Element("first");
        firstNameElement.appendChild(first);
        Element lastNameElement = new Element("last");
        lastNameElement.appendChild(last);
        Element addressElement = new Element("address");
        addressElement.appendChild(address);
        person.appendChild(firstNameElement);
        person.appendChild(lastNameElement);
        person.appendChild(addressElement);

        return person;
    }

    // Конструктор для восстановления Person из объекта XML Element
    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        address = person.getFirstChildElement("address").getValue();
    }

    public String toString() {
        return first + " " + last + ", address: " + address;
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
                new Person("Juran", "The Beardyman", "Yo City, Gagarina 15"),
                new Person("Zhenya", "The Designer", "Yo City, Petrova 22"),
                new Person("Yana", "The Zhopka", "Yo City, Solovjeva 22")
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
