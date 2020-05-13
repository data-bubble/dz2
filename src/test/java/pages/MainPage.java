package pages;

import annotations.CssSelector;
import annotations.Element;
import annotations.Elements;
import annotations.XpathSelector;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.constants.CssSelectors;
import test.constants.XpathSelectors;
import test.selectorEnum.SelectorEnum;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

@annotations.Page(title = "Главная",url = "https://dev.n7lanit.ru/")
public class MainPage extends AbstractPage {
    private List<String> subscribeThemes;

    public MainPage(){
        subscribeThemes=new ArrayList<>();
    }

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
    @Element("Подписки")
        public WebElement getSubscribeTab(){
        return getSelenideElement(XpathSelectors.SUBSCRIBE_TAB,SelectorEnum.XPATH_SELECTOR);
        }
    @XpathSelector(name = "Подписаться",selector = XpathSelectors.SUBSCRIBE_ITEM_OF_MENU)
    public By getElementsByMenu(By by){
        return by;
    }
    @XpathSelector(name = "заголовок",selector = XpathSelectors.TITLE_OF_THEME)
        public By getSelectorByElement(By by){
            return by;
        }
        @XpathSelector(name="Неактивна",selector=XpathSelectors.SUBSRIBE_BUTTON_MAIN)
    public By getXpathSelector(By by){
            return by;
        }
        public boolean addTheme(String theme) {
            return subscribeThemes.add(theme);
        }
        public List<String> getSubscribeThemes(){
        return subscribeThemes;
        }

}
