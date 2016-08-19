package tests;

import org.testng.annotations.Test;
import utils.SortedListOf;
import java.util.Random;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactModificationTest extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void modifySomeContact(ContactData contact){
        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        //actions
        app.getContactHelper().modifyContact(contact, index);
        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
    }
}