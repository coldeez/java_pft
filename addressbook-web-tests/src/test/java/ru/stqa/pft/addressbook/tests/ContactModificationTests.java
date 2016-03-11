package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("test1m", "test2m", "testmail1@mail.rum", "Citym, streetm, flatm", "testmail2@mail.rum", "+1234567890m", "+9061234567m", null), false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().returnToHomePage();
  }
}
