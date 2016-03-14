package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by kbal on 03.03.2016.
 */
public class GroupModificationTests extends TestBase {

   @Test
   public void testGroupModification(){
     app.getNavigationHelper().goToGroupPage();
       if (! app.getGroupHelper().isThereAGroup()) { /*проверка на наличие хотя бы одной группы*/
           app.getGroupHelper().createGroup(new GroupData("test1", null, null));
       }
     app.getGroupHelper().selectGroup();
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().fillGroupForm(new GroupData("test1", "test5", "test6"));
     app.getGroupHelper().submitGroupModification();
     app.getGroupHelper().returnToGroupPage();
   }

}
