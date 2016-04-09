package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kbal on 09.04.2016.
 */
public class ContactDetailedPageTests extends TestBase {

  @Test
  private void testContactDetailedPage() {
    app.contact().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromDetailedPage = app.contact().infoFromContactDetailedPage(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromDetailedPage)));


  }
}
