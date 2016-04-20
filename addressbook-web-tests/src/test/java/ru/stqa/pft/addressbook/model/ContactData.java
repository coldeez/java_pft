package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table (name = "addressbook")

public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Column(name = "firstname")
  private String firstname;
  @Column(name = "lastname")
  private String lastname;
  @Column(name = "email")
  @Type(type = "text")
  private String mail1;

  @Column(name = "email2")
  @Type(type = "text")
  private String mail2;
  @Column(name = "email3")
  @Type(type = "text")
  private String mail3;

  @Column(name = "address")
  @Type(type = "text")
  private String address;
  @Column(name = "home")
  @Type(type = "text")
  private String homephone;
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilephone;
  @Column(name = "work")
  @Type(type = "text")
  private String workphone;
  @Transient
  private String allPhones;

  @Transient

  private String details;
  @Transient
  private String fullname;
  @Transient
  private String fullEmail;
  @Transient
  private String  photo;
  @Transient
  private String allEmails;
  @Transient
  private String group;


  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }


  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }



  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail1() {
    return mail1;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail2() {
    return mail2;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getMobilephone() {
    return mobilephone;
  }
  public String getWorkphone() {
    return workphone;
  }


  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withMail1(String mail1) {
    this.mail1 = mail1;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMail2(String mail2) {
    this.mail2 = mail2;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  public ContactData withMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }

  public ContactData withWorkphone(String workphone) {
    this.workphone = workphone;
    return this;
  }


  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public String getEmail3() {
    return mail3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (mail1 != null ? !mail1.equals(that.mail1) : that.mail1 != null) return false;
    if (mail2 != null ? !mail2.equals(that.mail2) : that.mail2 != null) return false;
    if (mail3 != null ? !mail3.equals(that.mail3) : that.mail3 != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (homephone != null ? !homephone.equals(that.homephone) : that.homephone != null) return false;
    if (mobilephone != null ? !mobilephone.equals(that.mobilephone) : that.mobilephone != null) return false;
    return workphone != null ? workphone.equals(that.workphone) : that.workphone == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (mail1 != null ? mail1.hashCode() : 0);
    result = 31 * result + (mail2 != null ? mail2.hashCode() : 0);
    result = 31 * result + (mail3 != null ? mail3.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
    result = 31 * result + (mobilephone != null ? mobilephone.hashCode() : 0);
    result = 31 * result + (workphone != null ? workphone.hashCode() : 0);
    return result;
  }

  public ContactData withMail3(String mail3) {
    this.mail3 = mail3;
    return this;
  }

  public ContactData withDetails(String details) {
    this.details = details;
    return this;

  }
  public String getDetails() {
    return details;
  }

  public String getFullname() {
    fullname = getFirstname() + " " + getLastname();
    return fullname;
  }

  public String getFullEmail(String email) {
    if (email.isEmpty()) {
      return  email;
    }

    String domain = email.replaceAll("\\w+\\@","");
    fullEmail = email + " (www." + domain +")";
    return fullEmail;
    }


  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", mail1='" + mail1 + '\'' +
            ", mail2='" + mail2 + '\'' +
            ", mail3='" + mail3 + '\'' +
            '}';
  }

}

