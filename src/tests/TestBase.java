package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import framework.ApplicationManager;

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
}
