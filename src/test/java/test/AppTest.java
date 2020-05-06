package test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static test.selectorEnum.SelectorEnum.*;

import com.codeborne.selenide.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.constants.CssSelectors;
import test.constants.XpathSelectors;
import pages.interfaces.ElementAction;

/**
 * Unit test for simple App.
 */
public class AppTest implements ElementAction
{
    /**
     * Rigorous Test :-)
     *
     *
     */
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private static final String USER_NAME="ser";
    private static final String EMAIL ="yilana1117@tmajre.com";
    private static  final String PASSWORD="n7lanit12345";

@Before
public void setProp(){
    Configuration.timeout= 5000;
    Configuration.startMaximized=true;


}
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {

        open("https://dev.n7lanit.ru/");

        if(signIn())
            if(writeMessage()){

            Thread.sleep(1000);
            $(By.xpath(XpathSelectors.THEMES_BUTTON)).scrollIntoView(true).click();

                System.out.println(writeMessage());
            }







    }

    @After
    public void close()throws InterruptedException{
            Thread.sleep(10000);
    }


    private boolean signIn(){
        click(CssSelectors.LOGIN_BUTTON,CSS_SELECTOR);
        enterForm(CssSelectors.USER_NAME_FORM, CSS_SELECTOR, EMAIL);
        enterForm(CssSelectors.PASSWORD_FORM,CSS_SELECTOR,PASSWORD);
        click(XpathSelectors.LOGIN_SUBMIT_BUTTON,XPATH_SELECTOR);

    return $(CssSelectors.USER_NAVBAR_AVATAR).shouldBe(Condition.visible).isDisplayed();
    }

    private boolean writeMessage(){
        ElementsCollection collection=$$(CssSelectors.LIST_OF_THEMES).filterBy(text("Опрос"));
        int random=(int)(Math.random()*collection.size());
        SelenideElement element=collection.get(random);
        SelenideElement title=element.find(CssSelectors.TITLE_OF_THEME);
        title.shouldHave(Condition.visible).click();
        click(CssSelectors.ANSWER_BUTTON,CSS_SELECTOR);
        enterForm(CssSelectors.MESSAGE_FORM,CSS_SELECTOR,"карабли лавировали, лавировали, да...");
        click(CssSelectors.ANSWER_BUTTON_FOR_EDITOR,CSS_SELECTOR);

        return $$(CssSelectors.POSTS_COLLECTION).filterBy(text(USER_NAME)).last().shouldHave(text("карабли лавировали, лавировали, да...")).exists();

}




}
