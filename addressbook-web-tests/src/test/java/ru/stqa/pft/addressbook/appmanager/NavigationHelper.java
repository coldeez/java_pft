package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by kbal on 02.03.2016.
 */
public class NavigationHelper extends HelperBase {
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToHomePage() {
    click(By.linkText("home"));
  }


  public void acceptAlert(ApplicationManager applicationManager) {
    applicationManager.wd.switchTo().alert().accept();
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }
}
