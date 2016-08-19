package tests;

import org.testng.annotations.Test;
import utils.SortedListOf;
import java.util.Random;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GroupModificationTest extends TestBase{

    @Test(dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group){
        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        //actions
        app.getGroupHelper().modifyGroup(index, group);
        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
        //compare states
        assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
    }
}
