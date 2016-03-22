package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
  app.getContactHelper().goToHomePage();
  int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) { /*проверка на наличие хотя бы одного контакта*/
      app.getContactHelper().createGroup(new ContactData("test1", "test2", "testmail1@mail.ru", "City, street, flat", "testmail2@mail.ru", "+1234567890", "+9061234567", "test2"), true);
    }
  app.getContactHelper().selectContact(before - 1);
  app.getContactHelper().clickDeleteButton();
  app.navigationHelper.acceptAlert(app);
  int after = app.getContactHelper().getContactCount();
  if (before == 0) {
      Assert.assertEquals(after, before);
  }
  else Assert.assertEquals(after, before - 1);


  }
}
