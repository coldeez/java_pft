package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getContactHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isThereAContact()) {  /*проверка на наличие хотя бы одного контакта*/
      app.getContactHelper().createGroup(new ContactData("test1", "test2", "testmail1@mail.ru", "City, street, flat", "testmail2@mail.ru", "+1234567890", "+9061234567", "test1"), true);
    }
    if (before.size() != 0) {
      app.getContactHelper().selectContact(before.size() - 1);
    }
    else app.getContactHelper().selectContact(before.size());
    app.getContactHelper().editContact(before.size() - 1);
    app.getContactHelper().fillContactForm(new ContactData("test1m", "test2m", "testmail1@mail.rum", "Citym, streetm, flatm", "testmail2@mail.rum", "+1234567890m", "+9061234567m", null), false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

  }
}
