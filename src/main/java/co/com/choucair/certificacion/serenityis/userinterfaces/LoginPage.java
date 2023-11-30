package co.com.choucair.certificacion.serenityis.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("page:webdriver.base.url")
//@DefaultUrl("https://www.google.com")
public class LoginPage extends  PageObject{
    public static final Target INPUT_USER = Target.the("input the user")
            .located(By.name("Username"));
    public static final Target INPUT_PASSWORD = Target.the("input the password")
            .located(By.name("Password"));
    public static final Target SIGNIN = Target.the("button to submit")
            .located(By.xpath("//button[@type='submit']"));


}
