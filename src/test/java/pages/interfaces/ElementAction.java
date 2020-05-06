package pages.interfaces;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import test.selectorEnum.SelectorEnum;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertEquals;

public interface ElementAction {
    default void enterForm(String selector, SelectorEnum selectorEnum, String text){
        SelenideElement element=getSelenideElement(selector,selectorEnum);

        if(element!=null)
            element.shouldBe(Condition.enabled).sendKeys(text);
        assertEquals(element.getValue(),text);

    }

    default void click(String selector, SelectorEnum selectorEnum){
        SelenideElement element=getSelenideElement(selector,selectorEnum);
        if(element!=null)
            element.shouldHave(Condition.visible).shouldHave(enabled).click();

    }
    default SelenideElement getSelenideElement(String selector,SelectorEnum selectorEnum){
        SelenideElement element=null;
        switch (selectorEnum){
            case CSS_SELECTOR: return element=$(selector);

            case XPATH_SELECTOR: return element=$(By.xpath(selector));
            default:return null;
        }
    }
    default ElementsCollection getSelCollection(String selector, SelectorEnum selectorEnum){
        ElementsCollection element=null;
        switch (selectorEnum){
            case CSS_SELECTOR: return element=$$(selector);

            case XPATH_SELECTOR: return element=$$(By.xpath(selector));
            default:return null;
        }
    }

}
