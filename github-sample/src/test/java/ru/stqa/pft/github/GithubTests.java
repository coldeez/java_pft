package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by kbal on 25.04.2016.
 */
public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("2ec6919321a7cdff434c2abc7d3a7758639869cb");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("coldeez", "java_pft")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build()) ) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }

}
