package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
     Set<GroupData> before = app.group().all();
     int index = before.size() - 1;
     GroupData modifiedGroup = before.iterator().next();
     GroupData group = new GroupData().
             withId(modifiedGroup.getId()).withName("test2").withHeader("test5").withFooter("test6");
     app.group().modify(group);
     Set<GroupData> after = app.group().all();
     Assert.assertEquals(after.size(),before.size());
     before.remove(modifiedGroup);
     before.add(group);
     Assert.assertEquals(before, after);
   }


}
