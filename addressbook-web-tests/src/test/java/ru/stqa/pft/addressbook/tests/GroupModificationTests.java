package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kbal on 03.03.2016.
 */
public class GroupModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) { /*проверка на наличие хотя бы одной группы*/
      app.group().create(new GroupData().withName("test2"));
    }
  }

   @Test
   public void testGroupModification(){
     Groups before = app.group().all();
     GroupData modifiedGroup = before.iterator().next();
     GroupData group = new GroupData().
             withId(modifiedGroup.getId()).withName("test2").withHeader("test5").withFooter("test6");
     app.group().modify(group);
     assertThat(app.group().count(),equalTo(before.size()));
     Groups after = app.group().all();
     assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

   }
}
