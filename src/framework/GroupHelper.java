package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.GroupData;
import utils.SortedListOf;
import java.util.List;

public class GroupHelper extends HelperBase{

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    private SortedListOf<GroupData> cachedGroups;

    public SortedListOf<GroupData> getGroups() {
        if (cachedGroups == null){
            rebuildCache();
        }
        return cachedGroups;

    }

    private void rebuildCache() {
        cachedGroups = new SortedListOf<GroupData>();//или SortedListOf<GroupData> cachedGroups = new SortedListOf<GroupData>();

        manager.navigateTo().groupsPage();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for ( WebElement checkbox : checkboxes) {
            String title = checkbox.getAttribute("title");
            String groupname = title.substring("Select (".length(), title.length() - ")".length());
            cachedGroups.add(new GroupData().withName(groupname));
        }
    }

    public GroupHelper createGroup(GroupData group) {
        manager.navigateTo().groupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
        rebuildCache();
        return this;
    }

    public GroupHelper modifyGroup(int index, GroupData group) {
        initGroupModification(index);
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupsPage();
        rebuildCache();
        return this;
    }

    public GroupHelper deleteGroup(int index) {
        SelectGroupByIndex(index);
        submitGroupDeletion();
        returnToGroupsPage();
        rebuildCache();
        return this;
    }

    //----------------------------------------------------------------------------------------------------

    public GroupHelper initGroupCreation() {
        click(By.name("new"));
        return this;
    }

    public GroupHelper fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getGroupname());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
        return this;
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        cachedGroups = null;
        return this;
    }

    public GroupHelper returnToGroupsPage() {
        click(By.linkText("group page"));
        return this;
    }

    private GroupHelper SelectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
        return this;
    }

    public GroupHelper initGroupModification(int index) {
        SelectGroupByIndex(index);
        click(By.name("edit"));
        return this;
    }

    public GroupHelper submitGroupModification() {
        click(By.name("update"));
        cachedGroups = null;
        return this;
    }

    public void submitGroupDeletion() {
        click(By.name("delete"));
        cachedGroups = null;
    }
}
