package test;




//import test.pc.comp.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
//        System.setProperty("webdriver.chrome.driver","/Users/serikovsergej/coding/chromedriver");
//        WebDriver driver=new ChromeDriver();
//
//        driver.get("https://yandex.ru");
//        WebElement element=driver.findElement(By.name("text"));
//        element.sendKeys("во как");
//        element.submit();

        File file=new File("/Users/serikovsergej/coding/intellij_idea/maven_webdriver/src/main/java/test/pc/");
        URL url = file.toURI().toURL();
        System.out.println(url);
        URL[]urls = new URL[]{url};


        URLClassLoader classLoader=new URLClassLoader(urls);
     //   classLoader.loadClass("test.pc.Lo");
        File[] arr=arr=file.listFiles();
        if(arr.length>0)
        for(File f:arr){
            if(f.isFile()) {
                String fStr=f.getName();
                String str = "test.pc.";
                str += fStr.substring(0,fStr.indexOf('.'));
                Class<?> clazz=classLoader.loadClass(str);
      //          if(clazz.isAnnotationPresent(Page.class))
       //             System.out.println(clazz.getSimpleName());
            }
        }





    }
}
