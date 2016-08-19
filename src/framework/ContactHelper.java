package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.ContactData;
import utils.SortedListOf;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    private SortedListOf<ContactData> cachedContacts;

    public SortedListOf<ContactData> getContacts() {
        if (cachedContacts == null){
            rebuildCache();
        }
        return cachedContacts;
    }
    private void rebuildCache() {
        cachedContacts = new SortedListOf<ContactData>();//или SortedListOf<GroupData> cachedGroups = new SortedListOf<GroupData>();
        manager.navigateTo().mainPage();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for ( WebElement checkbox : checkboxes) {
            String title = checkbox.getAttribute("title");
            String first_name = title.substring("Select (".length(), title.lastIndexOf(' '));
            String second_name = title.substring(title.lastIndexOf(' ')+1, title.length() - ")".length());
            cachedContacts.add(new ContactData().withFirst_name(first_name).withSecond_name(second_name));
        }
    }

    public ContactHelper createContact(ContactData contact) {
        manager.navigateTo().mainPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
        rebuildCache();
        return this;
    }

    public ContactHelper modifyContact(ContactData contact, int index) {//важен ли порядок аргументов, узнать
        initContactModification(index+1);//1
        fillContactForm(contact);
        submitContactModification();
        returnToHomePage();
        rebuildCache();
        return this;
    }

    public ContactHelper deleteContact(int index) {
        initContactModification(index);
        submitContactDeletion();
        returnToHomePage();
        rebuildCache();
        return this;
    }

    //----------------------------------------------------------------------------------------------------

    public ContactHelper initContactCreation() {
        click(By.linkText("add new"));
        return this;
    }

    public ContactHelper fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.getFirst_name());
        type(By.name("lastname"), contact.getSecond_name());
        type(By.name("address"), contact.getAddress());
        type(By.name("email"), contact.getEmail());
        return this;
    }

    public ContactHelper submitContactCreation() {
        click(By.name("submit"));
        cachedContacts = null;
        return this;
    }

    public ContactHelper returnToHomePage() {
        click(By.linkText("home page"));
        return this;
    }

    public ContactHelper SelectContactByIndex(int index) {
        click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[7]/a/img"));
        return this;
    }

    public ContactHelper initContactModification(int index) {
        SelectContactByIndex(index);
        return this;
    }

    public ContactHelper submitContactModification() {
        click(By.xpath(".//*[@id='content']/form[1]/input[11]"));
        cachedContacts = null;
        return this;
    }
    public void submitContactDeletion() {
        click(By.xpath(".//*[@id='content']/form[2]/input[2]"));
        cachedContacts = null;
    }
}