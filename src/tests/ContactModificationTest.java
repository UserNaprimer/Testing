package tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
    @Test
    public void modifySomeContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModification(18);
        ContactData contact = new ContactData();
        contact.first_name = "MR.NOBODY";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
