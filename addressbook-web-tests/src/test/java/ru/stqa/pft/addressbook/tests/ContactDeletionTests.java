package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
  app.getNavigationHelper().goToHomePage();
  app.getContactHelper().selectContact();
  app.getContactHelper().clickDeleteButton();
  app.navigationHelper.acceptAlert(app);

  }
}
