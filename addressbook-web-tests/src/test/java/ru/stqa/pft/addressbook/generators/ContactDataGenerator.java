package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by kbal on 16.04.2016.
 */
public class ContactDataGenerator {

  private Properties properties;

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;


  @Parameter(names = "-d", description = "Data format")
  public String format;


  public  static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }


  private void run() throws IOException {
    properties = new Properties();
    String target = System.getProperty("target", "local");
    properties.load(new FileReader((new File(String.format("src/test/resources/%s.properties", target)))));
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }


  private List<ContactData> generateContacts(int count){
    File photo = new File(properties.getProperty("generator.contactPhoto"));
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++ ) {
      contacts.add(new ContactData().withFirstname(String.format("firstname %s", i)).withLastname(String.format("lastname %s", i))
              .withMail1(String.format("test1@mail.ru %s", i)).withAddress(String.format("City, street, flat %s", i))
              .withMail2(String.format("firstname %s", i)).withHomephone(String.format("123456%s", i))
              .withMobilephone(String.format("906123456 %s", i)).withPhoto(photo));
    }
    return contacts;

  }
  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try(Writer writer = new FileWriter(file)){
      writer.write(xml);
    }
  }



  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try(Writer writer = new FileWriter(file)){
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s\n",contact.getFirstname(), contact.getLastname(), contact.getEmail1(),
                contact.getAddress(), contact.getEmail2(), contact.getHomephone(), contact.getMobilephone(), contact.getPhoto()));
      }
    }
  }
}

