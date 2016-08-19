package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import framework.ApplicationManager;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TestBase {

    public static ApplicationManager app;// static добавил и все тесты запускаются в 1 браузере

    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();
    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator(){
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i=0; i<2; i++){
            GroupData group = new GroupData()
                    .withName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());
            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator(){
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i=0; i<10; i++){
            ContactData contact = new ContactData()
                    .withFirst_name(generateRandomString())
                    .withSecond_name(generateRandomString())
                    .withEmail(generateRandomString())
                    .withAddress(generateRandomString());
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

    public String generateRandomString(){
        Random rnd = new Random();
        if (rnd.nextInt(10) == 0) {
            return  "";
        } else {
            return "test" + rnd.nextInt();
        }
    }
}
