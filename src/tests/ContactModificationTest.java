package tests;

import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void modifySomeContact(ContactData contact){
        app.getNavigationHelper().openMainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        //actions
        app.getContactHelper().initContactModification(index+1);//1
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        oldList.remove(index);//0
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}