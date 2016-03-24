package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by kbal on 02.03.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() { /*проверка текущей страницы по заголовку*/
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))) { /*проверка текущей страницы по id таблицы*/
      return;
    }
    click(By.linkText("home page"));
  }
}
