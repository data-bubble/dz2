package pages;

import annotations.Element;
import annotations.Elements;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.constants.CssSelectors;
import test.constants.XpathSelectors;
import test.selectorEnum.SelectorEnum;

import static com.codeborne.selenide.Selenide.$;

@annotations.Page(title = "Главная",url = "https://dev.n7lanit.ru/")
public class MainPage extends AbstractPage {

        @Element("Темы")
    public WebElement getThemesTab(){
            return $(By.xpath(XpathSelectors.THEMES_BUTTON));
    }
    @Element("Ответить")
    public WebElement getAnswerButton(){
            return $(CssSelectors.ANSWER_BUTTON);
    }

    @Element("Войти")
    public WebElement getInputButton(){

            return getSelenideElement(CssSelectors.LOGIN_BUTTON, SelectorEnum.CSS_SELECTOR);
    }
    @Element("Логин")
    public WebElement getLoginForm(){
            return getSelenideElement(CssSelectors.USER_NAME_FORM,SelectorEnum.CSS_SELECTOR);
    }
    @Element("Пароль")
            public  WebElement getPasswordForm() {
        return getSelenideElement(CssSelectors.PASSWORD_FORM,SelectorEnum.CSS_SELECTOR);
    }
    @Element("Отправить")
        public  WebElement getSubmitButton() {
            return getSelenideElement(XpathSelectors.LOGIN_SUBMIT_BUTTON,SelectorEnum.XPATH_SELECTOR);
    }
    @Elements("Список Тем")
            public ElementsCollection getSelenideCollection(){
                return getSelCollection(CssSelectors.LIST_OF_THEMES,SelectorEnum.CSS_SELECTOR);


    }
}
