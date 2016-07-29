package framework;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        driver.get(manager.baseUrl + "/");
    }

    public void gotoGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }
}
