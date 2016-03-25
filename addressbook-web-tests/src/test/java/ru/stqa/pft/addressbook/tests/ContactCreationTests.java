package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.contact().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().
            withFirstname("test1").withLastname("test2").withMail1("testmail1@mail.ru").withAddress("City, street, flat").
            withMail2("testmail2@mail.ru").withHomephone("+1234567890").withMobilephone("+9061234567").withGroup("test2");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
