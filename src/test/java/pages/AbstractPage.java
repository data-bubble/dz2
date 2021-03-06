package pages;

import annotations.*;
import com.codeborne.selenide.ElementsCollection;
import org.apache.http.MethodNotSupportedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.interfaces.ElementAction;
import test.selectorEnum.SelectorEnum;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public abstract class AbstractPage implements ElementAction {
    public static final String PATH="/Users/serikovsergej/coding/intellij_idea/maven_webdriver/src/test/java/pages";
    public static final String PACK="pages";

    public static String getUrlByTitle(String title) throws InstantiationException, IllegalAccessException {

        try {
            AbstractPage abstractPage= getPageByTitle(title);
                return abstractPage.getClass().getAnnotation(Page.class).url();
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return null;

    }
    public WebElement getElementByName(String name) throws InvocationTargetException, IllegalAccessException,MethodNotSupportedException {

            for(Method method:this.getClass().getMethods()){
                Element element=method.getAnnotation(Element.class);
                if(element!=null&&element.value().equals(name))
                   return (WebElement) method.invoke(this);
            }
            throw new MethodNotSupportedException("нет такого метода");

    }

    public static AbstractPage getPageByTitle(String title) throws IllegalAccessException, InstantiationException,ClassNotFoundException {

        File file=new File(PATH);
        try{
            URL url = file.toURI().toURL();
            URL[]urls = new URL[]{url};


            URLClassLoader classLoader=new URLClassLoader(urls);
            File[] arr=file.listFiles();
            if(arr!=null)
                for(File f:arr){
                    if(f.isFile()) {
                        String fStr=f.getName();
                        String str = PACK+".";
                        str += fStr.substring(0,fStr.indexOf('.'));
                        Class<?> clazz=classLoader.loadClass(str);
                        if(clazz.isAnnotationPresent(Page.class))
                            if(clazz.getAnnotation(Page.class).title().equals(title))
                            return (AbstractPage) clazz.newInstance();
                    }
                }

        } catch (ClassNotFoundException | MalformedURLException e) {
            System.out.println("класс по аннотации не найден");
            e.printStackTrace();
        }
        throw new ClassNotFoundException("класса с аннотацией"+ title + "нет");

    }
    public ElementsCollection getElementsByName(String name) throws InvocationTargetException, IllegalAccessException, MethodNotSupportedException {
        for(Method method: this.getClass().getMethods()){
            Elements  elementsAn=method.getAnnotation(Elements.class);
            if(elementsAn!=null&& elementsAn.value().equals(name)){
               return(ElementsCollection) method.invoke(this);
            }
        }
        throw new MethodNotSupportedException("метода с аннотацией" + name +" нет");
    }
    public By getSelectorByName(String name) throws InvocationTargetException, IllegalAccessException, MethodNotSupportedException {
        for (Method method : this.getClass().getMethods()) {
            CssSelector elementAn = method.getAnnotation(CssSelector.class);
            if (elementAn != null && elementAn.name().equals(name)) {
                return (By)method.invoke(this,By.cssSelector(elementAn.selector()));
                }
            XpathSelector xpAn=method.getAnnotation(XpathSelector.class);
            if(xpAn != null && xpAn.name().equals(name))
             return (By)method.invoke(this,By.xpath(xpAn.selector()));
        }
        throw new MethodNotSupportedException("метода с аннотацией" + name +" нет");
    }


}
