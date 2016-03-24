package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
   public void ensurePreconditions () {
    app.contact().homePage();
    if ( app.contact().list().size() == 0) {  /*проверка на наличие хотя бы одного контакта*/
      app.contact().create(new ContactData("test1", "test2", "testmail1@mail.ru", "City, street, flat", "testmail2@mail.ru", "+1234567890", "+9061234567", "test2"), true);
    }
  }



  @Test
  public void testContactModification(){
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact = new ContactData(before.get(index).getId(),"test1m", "test2m", "testmail1@mail.rum", "Citym, streetm, flatm", "testmail2@mail.rum", "+1234567890m", "+9061234567m", "test2");
    app.contact().modify(before, index, contact);
    app.goTo().returnToHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
