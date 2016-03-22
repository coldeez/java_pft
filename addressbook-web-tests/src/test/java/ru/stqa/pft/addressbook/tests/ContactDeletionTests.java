package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
  app.getContactHelper().goToHomePage();
  if (! app.getContactHelper().isThereAContact()) { /*проверка на наличие хотя бы одного контакта*/
      app.getContactHelper().createGroup(new ContactData("test1", "test2", "testmail1@mail.ru", "City, street, flat", "testmail2@mail.ru", "+1234567890", "+9061234567", "test2"), true);
    }
  List<ContactData> before = app.getContactHelper().getContactList();
  app.getContactHelper().clickDeleteButton();
  app.navigationHelper.acceptAlert(app);
  app.getContactHelper().goToHomePage();
  List<ContactData> after = app.getContactHelper().getContactList();
  Assert.assertEquals(after.size(), before.size() - 1);
  }
}
