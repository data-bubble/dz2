package pages;

import annotations.Element;
import annotations.Elements;
import annotations.Page;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import test.constants.CssSelectors;
import test.constants.XpathSelectors;
import test.selectorEnum.SelectorEnum;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Page(title = "Топик",url = "https://dev.n7lanit.ru/t/new-topic-vegas/909/")
public class TopicPage extends AbstractPage {

    @Element("Форма")
    public SelenideElement getForm(){
        return getSelenideElement(CssSelectors.MESSAGE_FORM, SelectorEnum.CSS_SELECTOR);
    }
    @Element("Ответить")
    public WebElement getAnswerButton(){
        return $(CssSelectors.ANSWER_BUTTON);
    }

    @Element("Отправить ответ")
    public SelenideElement getSubmitAnswerButton(){return $(CssSelectors.ANSWER_BUTTON_FOR_EDITOR);}

    @Elements("Посты")
    public ElementsCollection getPostsCollection(){return $$(CssSelectors.POSTS_COLLECTION);}

    @Element("Темы")
    public SelenideElement getThemes(){return $(By.xpath(XpathSelectors.THEMES_BUTTON));}

}
