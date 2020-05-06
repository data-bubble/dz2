package stepdefs;

import com.codeborne.selenide.Configuration;
import cucumber.api.Result;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
    @Before
    public void before(){
        Configuration.timeout= 5000;
        Configuration.startMaximized=true;
    }
    @After
    public void after() throws InterruptedException{
        Thread.sleep(5000);
    }


}
