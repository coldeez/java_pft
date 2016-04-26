package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.security.acl.Group;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by kbal on 25.04.2016.
 */
public class ContactDeleteFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    app.contact().homePage();
    if ( app.db().contacts().size() == 0) {  /*проверка на наличие хотя бы одного контакта*/
      app.contact().create(new ContactData().
              withFirstname("firstname 0").withLastname("lastname").withMail1("test1@mail.ru").withMail2("test2@mail.ru").withMail3("test3@mail.ru")
              .withAddress("City, street, flat").withHomephone("1234560").withMobilephone("906123456").withWorkphone("44440").withPhoto(new File("src/test/resources/sands.jpg")), true);
    }

      if (app.db().groups().size() == 0) { /*проверка на наличие хотя бы одной группы*/
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test_test"));
      }
  }

  @Test
  public void testContactDeletionFromGroup() {
    app.contact().homePage();
    ContactData contact = app.db().contacts().iterator().next();
    Groups before = contact.getGroups();
    GroupData fromGroup = app.db().groups().iterator().next();
    if (before.size() == 0) {
      app.contact().addContactToGroup(contact, fromGroup);

    } else {
      fromGroup = contact.getGroups().iterator().next();
    }
    app.contact().homePage();
    app.contact().deleteContactFromGroup(contact, fromGroup);
    before.remove(fromGroup);
    assertThat(before, equalTo(app.db().contacts().stream().
            filter(c -> c.getId() == contact.getId()).findFirst().get().getGroups()));
    System.out.println(contact.getFullname() + " deleted from " + fromGroup.getName());
  }
}
