package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.security.acl.Group;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by kbal on 03.03.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("address"),contactData.getAddress());
    type(By.name("email"),contactData.getEmail1());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("home"),contactData.getHomephone());
    type(By.name("mobile"),contactData.getMobilephone());
    type(By.name("work"),contactData.getWorkphone());
    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group")))
                .selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void modify(ContactData contact) {
    int contactId = contact.getId();
    selectContactById(contactId);
    editContact(contactId);
    fillContactForm(contact, false);
    updateContact();
  }

  public void homePage() {
    if (isElementPresent(By.id("maintable"))) { /*проверка текущей страницы по id таблицы*/
      return;
    }
    click(By.linkText("home"));
  }

  public void initAccountCreation() {
    click(By.linkText("add new"));
  }


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" +id + "'")).click();
  }


  public void clickDeleteButton() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void editContact(int id) {


    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();

  }

  public void updateContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contact, boolean b) {
    initAccountCreation();
    fillContactForm(contact, b);
    submitContactCreation();
    homePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    clickDeleteButton();
    acceptAlert();
    homePage();
  }



  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public int getContactCount() {
  return  wd.findElements(By.name("entry")).size();

  }


  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    List<WebElement> lastnameContainer = wd.findElements(By.xpath("//td[2]"));
    List<WebElement> firstnameContainer = wd.findElements(By.xpath("//td[3]"));
    List<WebElement> addressContainer = wd.findElements(By.xpath("//td[4]"));
    List<WebElement> emailContainer = wd.findElements(By.xpath("//td[5]"));
    List<WebElement> phoneContainer = wd.findElements(By.xpath("//td[6]"));

    for (int i = 0; i < lastnameContainer.size(); i++) {
      String lastname = lastnameContainer.get(i).getText();
      String firstname = firstnameContainer.get(i).getText();
      String address = addressContainer.get(i).getText();
      String allEmails = emailContainer.get(i).getText();
      String allPhones = phoneContainer.get(i).getText();
      int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname)
              .withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones).withAddress(address));
    }
    return contacts;
  }


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomephone(home).withMobilephone(mobile).withWorkphone(work)
            .withMail1(email1).withMail2(email2).withMail3(email3).withAddress(address);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List <WebElement> cells = row.findElements((By.tagName("td")));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  public ContactData infoFromContactDetailedPage(ContactData contact) {
    initContactDetailedPageViewById(contact.getId());
    String detailsContent = wd.findElement(By.xpath("//*[@id='content']")).getText();
    String details = detailsContent;
    /*если неправильно настроен сервер*/
/*  String errors = wd.findElement(By.xpath("/[@id='content']/i")).getText();
    String details = detailsContent.replace(errors,"");*/
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withDetails(details);
  }

  private void initContactDetailedPageViewById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List <WebElement> cells = row.findElements((By.tagName("td")));
    cells.get(6).findElement(By.tagName("a")).click();
  }

  public void addContactToGroup(ContactData contact, GroupData groupname) {
    wd.findElement(By.cssSelector(String.format("input[value='%s']", contact.getId()))).click();
    Select groups = new Select(wd.findElements(By.name("to_group")).get(0));
    groups.selectByVisibleText(groupname.getName());
    wd.findElement(By.cssSelector("input[value='Add to'")).click();

  }

  public void deleteContactFromGroup(ContactData contact, GroupData fromGroup) {

    Select groups = new Select(wd.findElements(By.name("group")).get(0));
    groups.selectByVisibleText(fromGroup.getName());
    wd.findElement(By.cssSelector(String.format("input[value='%s']", contact.getId()))).click();
    wd.findElement(By.name("remove")).click();
  }



}
