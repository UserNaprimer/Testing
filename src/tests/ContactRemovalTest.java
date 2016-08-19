package tests;

import org.testng.annotations.Test;
import utils.SortedListOf;
import java.util.Random;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactRemovalTest extends TestBase{
 /* работающий тест для удаления нескольких элементов
    @Test
    public void deleteSomeContact(){
        app.navigateTo().mainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();
        Random rnd = new Random();
        int to_del = 2;
        //actions
        for (int i=0; i< to_del; i++) {
            int index = rnd.nextInt(oldList.size() - 1);
            app.getContactHelper().deleteContact(index+1);
            oldList.remove(index);
        }
        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

*/
    @Test
    public void deleteSomeContact(){
        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        //actions
        app.getContactHelper().deleteContact(index+1);
        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        assertThat(newList,equalTo(oldList.without(index)));
    }
}