package test.constants;

public class XpathSelectors {
    public static final String LOGIN_SUBMIT_BUTTON="//button[contains(@class,'btn-block') and @type='submit']";
    public static final String POLL="//ul[@class='list-group']//span[text()='Опрос']";
    public static final String THEMES_BUTTON="//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]";
 //   public static final String SUBSRIBE_BUTTON_MAIN="ul/preceding-sibling::button[@class='btn btn-default btn-icon btn-block btn-subscribe dropdown-toggle']";
// public static final String SUBSRIBE_BUTTON_MAIN="div/div/div/div[contains(@class,'media')]//button[contains(@class,'btn btn-default btn-icon btn-block btn-subscribe dropdown-toggle') and @data-toggle='dropdown']";
 public static final String SUBSRIBE_BUTTON_MAIN="div[2]/div[3]/div/div[1]/div/div/button";
//public static final String SUBSCRIBE_ITEM_OF_MENU="div/div/div/div/div/div/ul/li[2]/button";
    public static final String SUBSCRIBE_ITEM_OF_MENU="div[2]/div[3]/div/div[1]/div/div/ul/li[2]/button";
    public static final String TITLE_OF_THEME="div//a[contains(@class,'thread-title')]";
    public static final String SUBSCRIBE_TAB="//li/a[text()='Подписки']";

    public static final String SUBSCRIBE_LIST="//li[contains(@class,'thread-new')]";
    public static final String TITLE_OF_SUBSCRIBE="div//div[@class='media-body']/a[contains(@class,'thread-title')]";
    public static final String SUBSCRIBE_BUTTON="div[2]/div[3]/div/div[1]/div/div/button";
    public static final String UNSUBSCRIBE="div[2]/div[3]//li[1]/button";
}
//