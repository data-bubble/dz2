package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;
import test.constants.CssSelectors;
import test.constants.UserData;
import test.constants.XpathSelectors;
import test.interfaces.ElementAction;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static test.constants.UserData.USER_NAME;
import static test.selectorEnum.SelectorEnum.CSS_SELECTOR;
import static test.selectorEnum.SelectorEnum.XPATH_SELECTOR;

public class MyStepdefs implements ElementAction {

    @И("Открываем сайт")
    public void открываемСайт() {
        open("https://dev.n7lanit.ru/");
    }
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
    @И("нажимаем кнопку Ответить")
    public void нажимаемКнопкуОтветить() {
        click(CssSelectors.ANSWER_BUTTON,CSS_SELECTOR);
    }

    @И("вводим и отправляем текст из формы {string}")
    public void вводимИОтправляемТекстИзФормы(String arg0) {
        enterForm(CssSelectors.MESSAGE_FORM,CSS_SELECTOR,arg0);
        click(CssSelectors.ANSWER_BUTTON_FOR_EDITOR,CSS_SELECTOR);
    }


    @Тогда("преходим на вкладку темы")
    public void преходимНаВкладкуТемы() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath(XpathSelectors.THEMES_BUTTON)).scrollIntoView(true).click();
    }


    @Если("сообщение отображается в теме  {string}")
    public void сообщениеОтображаетсяВТеме(String arg0) {
        $$(CssSelectors.POSTS_COLLECTION).filterBy(text(USER_NAME)).last().shouldHave(text(arg0));
    }
}
