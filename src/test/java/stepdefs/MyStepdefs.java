package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.apache.http.MethodNotSupportedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import test.constants.CssSelectors;
import test.constants.UserData;
import test.constants.XpathSelectors;
import test.interfaces.ElementAction;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static test.constants.UserData.USER_NAME;
import static test.selectorEnum.SelectorEnum.CSS_SELECTOR;
import static test.selectorEnum.SelectorEnum.XPATH_SELECTOR;

public class MyStepdefs implements ElementAction {


    @И("нажимаем кнопку войти")
    public void нажимаемКнопкуВойти() {
        click(CssSelectors.LOGIN_BUTTON,CSS_SELECTOR);
    }
    @И("вводим логин")
    public void вводимЛогин() {
        enterForm(CssSelectors.USER_NAME_FORM, CSS_SELECTOR, UserData.EMAIL);
    }

    @И("вводим пароль")
    public void вводимПароль() {
        enterForm(CssSelectors.PASSWORD_FORM,CSS_SELECTOR,UserData.PASSWORD);
    }

    @И("нажимаем отправить")
    public void нажимаемОтправить() {
        click(XpathSelectors.LOGIN_SUBMIT_BUTTON,XPATH_SELECTOR);
    }


    @Если("авторизация прошла успешно")
    public void авторизацияПрошлаУспешно() {
       $(CssSelectors.USER_NAVBAR_AVATAR).shouldBe(Condition.visible);
    }

    @Тогда("открываем случайную тему не являющуюся опросом")
    public void открываемСлучайнуюТемуНеЯвляющуюсяОпросом() {

            ElementsCollection collection=$$(CssSelectors.LIST_OF_THEMES).filterBy(text("Опрос"));
            int random=(int)(Math.random()*collection.size());
            SelenideElement element=collection.get(random);
            SelenideElement title=element.find(CssSelectors.TITLE_OF_THEME);
            title.shouldHave(Condition.visible).click();

    }


    @И("вводим и отправляем текст из формы {string}")
    public void вводимИОтправляемТекстИзФормы(String arg0) throws InterruptedException {
        enterForm(CssSelectors.MESSAGE_FORM,CSS_SELECTOR,arg0);
        Thread.sleep(2000);
        click(CssSelectors.ANSWER_BUTTON_FOR_EDITOR,CSS_SELECTOR);
    }





    @Если("сообщение отображается в теме  {string}")
    public void сообщениеОтображаетсяВТеме(String arg0) {
        $$(CssSelectors.POSTS_COLLECTION).filterBy(text(USER_NAME)).last().shouldHave(text(arg0));
    }


//новые
    @И("Открываем страницу {string}")
    public void открываемСтраницу(String arg0) throws IllegalAccessException, InstantiationException {
        String page=  AbstractPage.getUrlByTitle(arg0);
        open(page);
    }

    @Тогда("на странице {string} переходим на вкладку {string}")
    public void наСтраницеПереходимНаВкладку(String title, String name) throws IllegalAccessException, InstantiationException,MethodNotSupportedException, InvocationTargetException,ClassNotFoundException {

            SelenideElement element=(SelenideElement) AbstractPage.getPageByTitle(title).getElementByName(name);
            if(element!=null)
                element.shouldHave(visible).click();

    }


    @И("на странице {string} нажимаем кнопку {string}")
    public void наСтраницеНажимаемКнопку(String title, String name) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException {
        SelenideElement element=(SelenideElement) AbstractPage.getPageByTitle(title).getElementByName(name);
        if(element!=null)
            element.shouldHave(visible).click();
    }
}
