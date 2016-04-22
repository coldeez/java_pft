package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.UserData;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by kbal on 22.04.2016.
 */
public class ChangePasswordTests extends  TestBase{

  @Test
  public void testChangePassword() throws IOException {

    UserData user = app.db().users().iterator().next();
    app.resetPassword().login("administrator", "root");
    app.resetPassword().resetUserPassword(user.getId());

/*    resetPassword();
    findLinkInEmail(mailMessages, email, regex);
    goToLink(link);
    type();
    assertTrue(app.newSession().login(user, password));*/
  }


}
