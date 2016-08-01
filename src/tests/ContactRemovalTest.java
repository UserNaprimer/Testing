package tests;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase{
    @Test
    public void deleteSomeContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModification(1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();
    }
}