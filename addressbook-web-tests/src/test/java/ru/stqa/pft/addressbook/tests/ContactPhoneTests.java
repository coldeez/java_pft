package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by kbal on 30.03.2016.
 */
public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {
  app.contact().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    MatcherAssert.assertThat(contact.getHomephone().equalTo);

  }


}
