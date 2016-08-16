package tests;

import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;

public class ContactRemovalTest extends TestBase{
    @Test
    public void deleteSomeContact(){
        app.getNavigationHelper().openMainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();
        Random rnd = new Random();
        int to_del = 7;

        //actions
        for (int i=0; i< to_del; i++) {
            int index = rnd.nextInt(oldList.size() - 1);
            app.getContactHelper().initContactModification(index+1);
            app.getContactHelper().deleteContact();
            app.getContactHelper().returnToHomePage();
            oldList.remove(index);
        }
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}