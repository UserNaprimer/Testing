package tests;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactCreation();
        ContactData contact = new ContactData();
        contact.first_name = "name";
        contact.second_name = "surname";
        contact.address = "Moscow, red square";
        contact.email = "qwerty@qwerty.com";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

    @Test
    public void testEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("", "", "", ""));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }
}