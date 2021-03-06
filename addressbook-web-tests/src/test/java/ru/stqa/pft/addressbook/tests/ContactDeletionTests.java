package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    app.contact().homePage();
    if ( app.db().contacts().size() == 0) {  /*проверка на наличие хотя бы одного контакта*/
      app.contact().create(new ContactData().
              withFirstname("firstname 0").withLastname("lastname").withMail1("test1@mail.ru").withMail2("test2@mail.ru").withMail3("test3@mail.ru")
              .withAddress("City, street, flat").withHomephone("1234560").withMobilephone("906123456").withWorkphone("44440").withPhoto(new File("src/test/resources/sands.jpg")), true);
    }
  }
  @Test
  public void testContactDeletion() {
  Contacts before = app.db().contacts();
  ContactData deletedContact = before.iterator().next();
  app.contact().delete(deletedContact);
  Contacts after = app.db().contacts();
  Assert.assertEquals(after.size(), before.size() - 1);
  assertThat(after, equalTo(before.without(deletedContact)));
  }
}
