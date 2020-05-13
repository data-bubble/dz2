package pages;

import annotations.Element;
import annotations.Elements;
import annotations.Page;
import annotations.XpathSelector;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.mn.Харин;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import test.constants.CssSelectors;
import test.constants.XpathSelectors;
import test.selectorEnum.SelectorEnum;

import static com.codeborne.selenide.Selenide.$;

@annotations.Page(title = "Подписок",url="https://dev.n7lanit.ru/subscribed")
public class SubscribePage extends AbstractPage {

    @Element("Тема")
    public WebElement getTheme(){
        return $(By.cssSelector("#page-mount > div > div.page-header-bg > div > div.container > div > div.col-sm-3.col-md-2.xs-margin-top > button"));

}

   @Elements("Списке подписок")
    public ElementsCollection getSubscribes(){
       return getSelCollection(XpathSelectors.SUBSCRIBE_LIST, SelectorEnum.XPATH_SELECTOR);
   }
    @XpathSelector(name = "заголовок подписки",selector = XpathSelectors.TITLE_OF_SUBSCRIBE)
    public By getTitleSelectorOfSubscribes(By by){
        return by;
    }

    @XpathSelector(name = "кнопка подписки",selector = XpathSelectors.SUBSCRIBE_BUTTON)
    public By getTitleSelectorOfSubscribeButton(By by){
        return by;
    }
    @XpathSelector(name = "Отписаться",selector = XpathSelectors.UNSUBSCRIBE)
    public By getTitleSelectorOfUnsubscribe(By by){
        return by;
    }


}
