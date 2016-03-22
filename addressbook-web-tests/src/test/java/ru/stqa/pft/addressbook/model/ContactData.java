package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String mail1;
  private final String address;
  private final String mail2;
  private final String homephone;
  private final String mobilephone;
  private int id;
  private String group;

  public ContactData(String firstname, String lastname, String mail1, String address, String mail2, String homephone, String mobilephone, String group) {
    this.id = 0;
    this.firstname = firstname;
    this.lastname = lastname;
    this.mail1 = mail1;
    this.address = address;
    this.mail2 = mail2;
    this.homephone = homephone;
    this.mobilephone = mobilephone;
    this.group = group;
  }

  public ContactData(int id, String firstname, String lastname, String mail1, String address, String mail2, String homephone, String mobilephone, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.mail1 = mail1;
    this.address = address;
    this.mail2 = mail2;
    this.homephone = homephone;
    this.mobilephone = mobilephone;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMail1() {
    return mail1;
  }

  public String getAddress() {
    return address;
  }

  public String getMail2() {
    return mail2;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }
}
