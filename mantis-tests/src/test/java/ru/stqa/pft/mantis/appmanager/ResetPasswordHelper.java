package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by kbal on 21.04.2016.
 */
public class ResetPasswordHelper extends HelperBase{

  public ResetPasswordHelper(ApplicationManager app) {
    super(app);
  }

  public void resetUserPassword(int userId) {

    wd.findElement(By.linkText("Manage Users")).click();
    wd.findElement(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']",userId))).click();
  }

  public void login(String username, String password) {
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }
}