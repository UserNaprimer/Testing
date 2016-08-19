package tests;

import org.testng.annotations.Test;
import utils.SortedListOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
        //actions
        app.getContactHelper().createContact(contact);
        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        assertThat(newList,equalTo(oldList.withAdded(contact)));
    }
}