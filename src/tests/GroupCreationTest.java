package tests;

import org.testng.annotations.Test;
import utils.SortedListOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GroupCreationTest extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
        //actions
        app.getGroupHelper().createGroup(group);
        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
        //compare states
        assertThat(newList, equalTo(oldList.withAdded(group)));
    }
}
