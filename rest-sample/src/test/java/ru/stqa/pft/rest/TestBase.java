package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kbal on 02.03.2016.
 */
public class TestBase {

  public boolean isIssueOpen(int issueId) throws IOException {
        if (getIssueStatus(issueId).equals("Closed")) {
      return false;
    }
    return true;
  }

  @BeforeSuite
  public void skipIfNotFixed() throws IOException {
    List<String> list = new ArrayList<String>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/blockers_list.txt")));
    String line = reader.readLine();
    while (line != null) {
      list.add(line);
      line = reader.readLine();
    }
    for (String issueId : list) {
      if (isIssueOpen(Integer.parseInt(issueId))) {
        System.out.println("Ignored because of issue " + issueId);
        throw new SkipException("Ignored because of issue " + issueId);
      }
    }
  }

  private Executor getExecutor() {
    return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==","");
  }


  private String getIssueStatus(int issueId) throws IOException {
    String json = getExecutor().execute(Request.Get(String.format("http://demo.bugify.com/api/issues/%s.json", issueId)))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    List<Issue> issueData = new Gson().fromJson(issues, new TypeToken<List<Issue>>(){}.getType());
    for (Issue issue : issueData) {
      if (issue.getId() == issueId) {
        return issue.getState_name();
      }
    }
    return null;
  }

}
