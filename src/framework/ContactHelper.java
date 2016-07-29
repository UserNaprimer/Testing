package framework;

import org.openqa.selenium.By;
import tests.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contact) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contact.first_name);
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contact.second_name);
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contact.address);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contact.email);
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }
}
