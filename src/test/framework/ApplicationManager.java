import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;


public class ApplicationManager {

    public void returnToGroupsPage() {
        TestBase.driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        TestBase.driver.findElement(By.name("submit")).click();
    }

    public void initGroupCreation() {
        TestBase.driver.findElement(By.name("new")).click();
    }

    public void gotoGroupsPage() {
        TestBase.driver.findElement(By.linkText("groups")).click();
    }

    public void openMainPage() {
        TestBase.driver.get(TestBase.baseUrl + "/");
    }

    public boolean isElementPresent(By by) {
        try {
            TestBase.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            TestBase.driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = TestBase.driver.switchTo().alert();
            String alertText = alert.getText();
            if (TestBase.acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            TestBase.acceptNextAlert = true;
        }
    }

    public void returnToHomePage() {
        TestBase.driver.findElement(By.linkText("home page")).click();
    }

    public void submitContactCreation() {
        TestBase.driver.findElement(By.name("submit")).click();
    }

    public void initContactCreation() {
        TestBase.driver.findElement(By.linkText("add new")).click();
    }


    public void fillContactForm(ContactData contact) {
        TestBase.driver.findElement(By.name("firstname")).clear();
        TestBase.driver.findElement(By.name("firstname")).sendKeys(contact.first_name);
        TestBase.driver.findElement(By.name("lastname")).clear();
        TestBase.driver.findElement(By.name("lastname")).sendKeys(contact.second_name);
        TestBase.driver.findElement(By.name("address")).clear();
        TestBase.driver.findElement(By.name("address")).sendKeys(contact.address);
        TestBase.driver.findElement(By.name("email")).clear();
        TestBase.driver.findElement(By.name("email")).sendKeys(contact.email);
    }

    public void fillGroupForm(GroupData group) {
        TestBase.driver.findElement(By.name("group_name")).clear();
        TestBase.driver.findElement(By.name("group_name")).sendKeys(group.groupname);
        TestBase.driver.findElement(By.name("group_header")).clear();
        TestBase.driver.findElement(By.name("group_header")).sendKeys(group.header);
        TestBase.driver.findElement(By.name("group_footer")).clear();
        TestBase.driver.findElement(By.name("group_footer")).sendKeys(group.footer);
    }
}
