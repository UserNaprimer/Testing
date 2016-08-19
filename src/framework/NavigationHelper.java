package framework;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void mainPage() {
        if (! onMainPage()){
            click(By.linkText("home"));
        }
    }

    private boolean onMainPage() {
       return driver.findElements(By.id("maintable")).size() > 0;
    }

    public void groupsPage() {
        if(! onGroupPage()){
            click(By.linkText("groups"));
        }
    }

    private boolean onGroupPage() {
        return (driver.getCurrentUrl().contains("/group.php")
        && driver.findElements(By.name("new")).size() > 0);
    }
}
