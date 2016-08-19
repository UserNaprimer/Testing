package tests;

import org.testng.annotations.Test;
import utils.SortedListOf;
import java.util.Random;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GroupRemovalTest extends TestBase{
    @Test
    public void deleteSomeGroup(){
        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        //actions
        app.getGroupHelper().deleteGroup(index);
        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
        //compare states
        assertThat(newList,equalTo(oldList.without(index)));
    }
}
