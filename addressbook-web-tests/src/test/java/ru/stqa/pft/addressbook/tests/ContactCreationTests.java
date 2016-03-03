package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().initAccountCreation();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "testmail1@mail.ru", "City, street, flat", "testmail2@mail.ru", "+1234567890", "+9061234567"));
    app.getContactHelper().submitAccountCreation();
    app.getNavigationHelper().returnToHomePage();
  }

}
