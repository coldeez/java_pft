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
    this.id = Integer.MAX_VALUE;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", mail1='" + mail1 + '\'' +
            ", address='" + address + '\'' +
            ", mail2='" + mail2 + '\'' +
            ", homephone='" + homephone + '\'' +
            ", mobilephone='" + mobilephone + '\'' +
            ", id=" + id +
            ", group='" + group + '\'' +
            '}';
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
  public void setId(int id) {
    this.id = id;
  }
}

