package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import javax.xml.rpc.ServiceException;
import java.io.*;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kbal on 02.03.2016.
 */
public class TestBase {
  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
/*
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
*/
  }
  public boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (app.soap().getIssueStatus(issueId) == "fixed") {
      return true;
    }
    return false;

  }
  @BeforeSuite
  public void skipIfNotFixed() throws IOException, ServiceException {
    List<String> list = new ArrayList<String>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/blockers_list.txt")));
    String line = reader.readLine();
    while (line !=null) {
      list.add(line);
      line = reader.readLine();
    }

    for ( String issueId : list) {
      if (isIssueOpen(Integer.parseInt(issueId))) {
        System.out.println("Ignored because of issue " + issueId);
        throw new SkipException("Ignored because of issue " + issueId);
      }
    }
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
/*
    app.ftp().restore("config_inc.php.bak","config_inc.php");
*/
    app.stop();
  }


}
