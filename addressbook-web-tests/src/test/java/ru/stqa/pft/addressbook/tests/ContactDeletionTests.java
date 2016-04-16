package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    app.contact().homePage();
    if ( app.contact().all().size() == 0) {  /*проверка на наличие хотя бы одного контакта*/
      app.contact().create(new ContactData().
              withFirstname("test1").withLastname("test2").withMail1("testmail1@mail.ru").withAddress("City, street, flat").
              withMail2("testmail2@mail.ru").withHomephone("+1234567890").withMobilephone("+9061234567").withGroup("test2"), true);
    }
  }
  @Test
  public void testContactDeletion() {
  Contacts before = app.contact().all();
  ContactData deletedContact = before.iterator().next();
  app.contact().delete(deletedContact);
  Contacts after = app.contact().all();
  Assert.assertEquals(after.size(), before.size() - 1);
  assertThat(after, equalTo(before.without(deletedContact)));
  }
}
