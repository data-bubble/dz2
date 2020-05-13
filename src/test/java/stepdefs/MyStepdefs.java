package stepdefs;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.apache.http.MethodNotSupportedException;
import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AbstractPage;
import pages.MainPage;
import pages.SubscribePage;
import test.constants.CssSelectors;
import pages.interfaces.ElementAction;

import javax.swing.text.html.Option;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.source;
import static pages.AbstractPage.getPageByTitle;
import static test.constants.UserData.USER_NAME;

public class MyStepdefs implements ElementAction {
private MainPage mainPage;

    @Если("авторизация прошла успешно")
    public void авторизацияПрошлаУспешно() {
       $(CssSelectors.USER_NAVBAR_AVATAR).shouldBe(Condition.visible);
    }



//новые
    @И("Открываем страницу {string}")
    public void открываемСтраницу(String arg0) throws IllegalAccessException, InstantiationException {
        String page=  AbstractPage.getUrlByTitle(arg0);
        open(page);
    }

    @Тогда("на странице {string} переходим на вкладку {string}")
    public void наСтраницеПереходимНаВкладку(String title, String name) throws IllegalAccessException, InstantiationException,MethodNotSupportedException, InvocationTargetException,ClassNotFoundException {

            SelenideElement element=(SelenideElement) getPageByTitle(title).getElementByName(name);
            if(element!=null)
                element.shouldHave(visible).click();

    }


    @И("на странице {string} нажимаем кнопку {string}")
    public void наСтраницеНажимаемКнопку(String title, String name) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException {
        SelenideElement element=(SelenideElement) getPageByTitle(title).getElementByName(name);
        if(element!=null)
            element.shouldBe(enabled).click();
    }


    @И("на странице {string} заполняем форму {string} данными {string}")
    public void наСтраницеЗаполняемФормуДанными(String title, String name, String data) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException, InterruptedException {
        SelenideElement form=(SelenideElement) getPageByTitle(title).getElementByName(name);
        form.shouldBe(enabled).sendKeys(data);
    }

    @Тогда("на странице {string} кликаем {string} из {string} не являющейся {string}")
    public void наСтраницеОткрываемСлучайныйЭлементИзНеЯвляющийся(String title, String selector,String nameOfList, String ignoreText) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException {
        mainPage=(MainPage) getPageByTitle(title);
        ElementsCollection collection=mainPage.getElementsByName(nameOfList);
     //   SelenideElement element=collection.stream().filter((el)->!(el.getText().contains(ignoreText))).findAny().get();
        ElementsCollection filterCollection=collection.filterBy(Condition.not(text(ignoreText)));
        int random=(int)(Math.random()*filterCollection.size());

        SelenideElement element=filterCollection.get(random);
        SelenideElement titleOfelement=element.find(mainPage.getSelectorByName(selector));

//        Actions mouse=new Actions(getWebDriver());
//
//        mouse.moveToElement(titleOfelement).click();
        titleOfelement.shouldBe(enabled).click();






    }

    @И("на странице {string} вводим в форму текст {string}")
    public void наСтраницеВводимВФормуТекст(String title, String text) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException, InterruptedException {
        SelenideElement element=(SelenideElement) getPageByTitle(title).getElementByName("Форма");
        element.shouldBe(visible).sendKeys(text);
        Thread.sleep(3000);

    }

    @Если("на странице {string} сообщение {string} отобразилось")
    public void наСтраницеСообщениеОтобразилось(String title, String text) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException, InterruptedException {
        ElementsCollection collection = getPageByTitle(title).getElementsByName("Посты");
        collection.filterBy(text(USER_NAME)).last().shouldHave(text(text));
    }

    @Тогда("на странице {string} выбираем тему из {string} нажимаем на кнопку {string} и выбираем {string}")
    public void наСтраницеНажимаемНаКнопкуНаСлучайнуюТемуИз(String title,String nameOfList, String textButton,String itemOfMenu) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException {
        if(mainPage==null)
        mainPage=(MainPage)getPageByTitle(title);
        ElementsCollection collection=mainPage.getElementsByName(nameOfList);
        //   SelenideElement element=collection.stream().filter((el)->!(el.getText().contains(ignoreText))).findAny().get();
        String matchText=".*("+textButton+")";
        ElementsCollection filterCollection=collection.filterBy(matchText(matchText));
        int random=(int)(Math.random()*filterCollection.size());

        SelenideElement element=filterCollection.get(random);
        SelenideElement subscribeButton=element.find(mainPage.getSelectorByName(textButton));
        subscribeButton.shouldBe(visible).click();

   //     Actions mouse=new Actions(getWebDriver());
    //    mouse.moveToElement(subscribeButton).click().build().perform();

        SelenideElement subscribeItem=element.find(mainPage.getSelectorByName(itemOfMenu));

        SelenideElement subscribeTheme=element.find(mainPage.getSelectorByName("заголовок"));
        mainPage.addTheme(subscribeTheme.shouldBe(enabled).getText());
        subscribeItem.shouldBe(enabled).click();
     //   mouse.moveToElement(subscribeItem).click().build().perform();

    }


    @И("на странице {string} в {string} проверяем подписки")
    public void наСтраницеПроверямПодписки(String title,String nameOflist) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException {
        SubscribePage page=(SubscribePage) getPageByTitle(title);

    ElementsCollection collection=page.getElementsByName(nameOflist);
        System.out.println(collection.shouldBe(CollectionCondition.sizeNotEqual(0)).size());
        ElementsCollection filterByUser=collection.filterBy(text(USER_NAME));

        for(SelenideElement element:filterByUser){
            SelenideElement tit=element.find(page.getSelectorByName("заголовок подписки"));
            tit.shouldBe(visible);
            if(mainPage.getSubscribeThemes().contains(tit.getText()))
                System.out.println(true);
            else
                Assert.fail();
        }

    }

    @И("на странице {string} в {string} на каждой нажимаем {string} и выбераем {string}")
    public void наСтраницеВНаКаждойНажимаемИВыбераем(String title, String nameOflist, String subscribeButton, String unsubscribe) throws IllegalAccessException, MethodNotSupportedException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        SubscribePage page=(SubscribePage) getPageByTitle(title);
        ElementsCollection collection=page.getElementsByName(nameOflist);
        System.out.println(collection.shouldBe(CollectionCondition.sizeNotEqual(0)).size());
        ElementsCollection filterByUser=collection.filterBy(text(USER_NAME));
        for(SelenideElement element:filterByUser) {
            SelenideElement subButton = element.find(page.getSelectorByName(subscribeButton));
            subButton.shouldBe(enabled).click();
            SelenideElement unSubscrinbe = element.find(page.getSelectorByName(unsubscribe));
            unSubscrinbe.shouldBe(enabled).click();
        }
    }
}
