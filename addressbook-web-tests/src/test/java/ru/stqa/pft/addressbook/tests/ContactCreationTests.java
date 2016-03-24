package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.contact().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("test1", "test2", "testmail1@mail.ru", "City, street, flat", "testmail2@mail.ru", "+1234567890", "+9061234567", "test2");
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
