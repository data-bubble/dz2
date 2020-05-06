package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.apache.http.MethodNotSupportedException;
import pages.AbstractPage;
import test.constants.CssSelectors;
import pages.interfaces.ElementAction;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static pages.AbstractPage.getPageByTitle;
import static test.constants.UserData.USER_NAME;

public class MyStepdefs implements ElementAction {


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
            element.shouldBe(visible).click();
    }


    @И("на странице {string} заполняем форму {string} данными {string}")
    public void наСтраницеЗаполняемФормуДанными(String title, String name, String data) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException, InterruptedException {
        SelenideElement form=(SelenideElement) getPageByTitle(title).getElementByName(name);
        form.shouldBe(enabled).sendKeys(data);
    }

    @Тогда("на странице {string} открываем случайный элемент из {string} не являющийся {string}")
    public void наСтраницеОткрываемСлучайныйЭлементИзНеЯвляющийся(String title, String nameOfList, String ignoreText) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, MethodNotSupportedException {
        ElementsCollection collection=getPageByTitle(title).getElementsByName(nameOfList);
        SelenideElement element=collection.stream().filter((el)->!(el.getText().contains(ignoreText))).findAny().get();
   //     int random=(int)(Math.random()*collection.size());
       // SelenideElement element=collection.get(random);
        SelenideElement titleOfelement=element.find(CssSelectors.TITLE_OF_THEME);
       titleOfelement.shouldHave(Condition.visible).click();



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
}
