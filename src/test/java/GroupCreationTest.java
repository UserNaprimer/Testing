import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app = new ApplicationManager();

        app.openMainPage();
        app.gotoGroupsPage();
        app.initGroupCreation();
        GroupData group = new GroupData();
        group.groupname = "group name 1";
        group.header = "header 1";
        group.footer = "footer 1";
        app.fillGroupForm(group);
        app.submitGroupCreation();
        app.returnToGroupsPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app = new ApplicationManager();

        app.openMainPage();
        app.gotoGroupsPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("", "", ""));
        app.submitGroupCreation();
        app.returnToGroupsPage();
    }
}
