package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    app.contact().homePage();
    if ( app.contact().list().size() == 0) {  /*проверка на наличие хотя бы одного контакта*/
      app.contact().create(new ContactData("test1", "test2", "testmail1@mail.ru", "City, street, flat", "testmail2@mail.ru", "+1234567890", "+9061234567", "test2"), true);
    }
  }

  @Test
  public void testContactDeletion() {
  List<ContactData> before = app.contact().list();
  int index = before.size() -1;
  app.contact().delete(index);
  List<ContactData> after = app.contact().list();
  Assert.assertEquals(after.size(), before.size() - 1);
  before.remove(index);
    Assert.assertEquals(after,before);
  }
}
