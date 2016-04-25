package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by kbal on 25.04.2016.
 */
public class ContactDeleteFromGroupTests extends TestBase {

  @Test
  public void testContactDeletionFromGroup() {
    app.goTo().returnToHomePage();
    app.contact().deleteContactFromGroup();

  }
}
