package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kbal on 09.04.2016.
 */
public class ContactDetailedPageTests extends TestBase {


  @Test
  public void testContactDetail() {
    app.contact().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactInfoFromDetails = app.contact().infoFromContactDetailedPage(contact);
    assertThat(cleaned(mergeFromEditForm(contactInfoFromEditForm)), equalTo(cleaned(contactInfoFromDetails.getDetails())));
  }

  public String cleaned(String detail) {
    return detail.replaceAll("\\s","");
  }


  private String mergeFromEditForm(ContactData contact) {
    String homePhone = contact.getHomephone();
    String mobilePhone = contact.getMobilephone();
    String workPhone = contact.getWorkphone();
    if (homePhone.length() > 0) {
      homePhone = "H: " + homePhone;
    }
    if (mobilePhone.length() > 0) {
      mobilePhone = "M: " + mobilePhone;
    }
    if (workPhone.length() > 0) {
      workPhone = "W: " + workPhone;
    }
    return Arrays.asList(contact.getFullname(), contact.getAddress(), "",
            homePhone, mobilePhone, workPhone, "",
            contact.getFullEmail(contact.getEmail1()), contact.getFullEmail(contact.getEmail2()), contact.getFullEmail(contact.getEmail3()), "\n\n")
            .stream().collect(Collectors.joining(""));
  }
}
