package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getContactHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {  /*проверка на наличие хотя бы одного контакта*/
      app.getContactHelper().createGroup(new ContactData("test1", "test2", "testmail1@mail.ru", "City, street, flat", "testmail2@mail.ru", "+1234567890", "+9061234567", "test2"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().editContact(before.get(before.size()-1).getId());
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"test1m", "test2m", "testmail1@mail.rum", "Citym, streetm, flatm", "testmail2@mail.rum", "+1234567890m", "+9061234567m", "test2");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
