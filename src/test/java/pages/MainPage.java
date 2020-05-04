package pages;

import annotations.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.constants.CssSelectors;
import test.constants.XpathSelectors;

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

}
