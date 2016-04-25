package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by kbal on 25.04.2016.
 */
public class ContactToGroupTests extends TestBase{

  @Test
  public void testContactAddToGroup() {
  app.goTo().returnToHomePage();
  app.contact().addContactToGroup(app.db().groups().iterator().next().getName());

  }

}


