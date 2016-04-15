package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.contact().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/sands.jpg");
    ContactData contact = new ContactData().
            withFirstname("test1").withLastname("test2").withMail1("testmail1@mail.ru").withAddress("City, street, flat")
            .withMail2("testmail2@mail.ru").withHomephone("+1234567890").withMobilephone("+9061234567").withGroup("test2")
            .withPhoto(photo);

    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
  }

}
