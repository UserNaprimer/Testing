package framework;

import org.openqa.selenium.By;
import tests.GroupData;

public class GroupHelper extends HelperBase{

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.groupname);
        type(By.name("group_header"), group.header);
        type(By.name("group_footer"), group.footer);

    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void deleteGroup(int index) {
        SelectGroupByIndex(index);
        click(By.name("delete"));
    }

    private void SelectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + index + "]"));
    }

    public void initGroupModification(int index) {
        SelectGroupByIndex(index);
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
