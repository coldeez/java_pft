package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.testng.Assert.assertEquals;

/**
 * Created by kbal on 25.04.2016.
 */
public class ContactToGroupTests extends TestBase{

  @Test
  public void testContactAddToGroup() {
  app.goTo().returnToHomePage();
  ContactData contact = app.db().contacts().iterator().next();
  GroupData toGroup = app.db().groups().iterator().next();
  Groups before = contact.getGroups();
  app.contact().addContactToGroup(contact, toGroup);
  Groups after = contact.getGroups();
  before.add(toGroup);
  assertEquals(before, after);
  System.out.println(contact.getFullname() + " added to " + toGroup.getName());

  }

}


