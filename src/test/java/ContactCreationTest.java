import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app = new ApplicationManager();

        app.openMainPage();
        app.initContactCreation();
        ContactData contact = new ContactData();
        contact.first_name = "name";
        contact.second_name = "surname";
        contact.address = "Moscow, red square";
        contact.email = "qwerty@qwerty.com";
        app.fillContactForm(contact);
        app.submitContactCreation();
        app.returnToHomePage();
    }

    @Test
    public void testEmptyContactCreation() throws Exception {
        app = new ApplicationManager();

        app.openMainPage();
        app.initContactCreation();
        app.fillContactForm(new ContactData("", "", "", ""));
        app.submitContactCreation();
        app.returnToHomePage();
    }
}