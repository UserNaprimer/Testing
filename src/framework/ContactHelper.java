package framework;

import org.openqa.selenium.By;
import tests.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.first_name);
        type(By.name("lastname"), contact.second_name);
        type(By.name("address"), contact.address);
        type(By.name("email"), contact.email);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }
    private void SelectContactByIndex(int index) {
        click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[7]/a/img"));
    }
    public void initContactModification(int index) {
        SelectContactByIndex(index);
    }

    public void deleteContact() {
        click(By.xpath(".//*[@id='content']/form[2]/input[2]"));
    }

    public void submitContactModification() {
        click(By.xpath(".//*[@id='content']/form[1]/input[11]"));
    }
}
