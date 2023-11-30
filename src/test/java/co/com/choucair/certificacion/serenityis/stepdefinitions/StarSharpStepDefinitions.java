package co.com.choucair.certificacion.serenityis.stepdefinitions;

import co.com.choucair.certificacion.serenityis.userinterfaces.LoginPage;
import co.com.choucair.certificacion.serenityis.utils.KillBrowser;
import co.com.choucair.certificacion.serenityis.utils.ReadProporties;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.environment.MockEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.choucair.certificacion.serenityis.userinterfaces.LoginPage.*;
import static co.com.choucair.certificacion.serenityis.userinterfaces.LoginPage.SIGNIN;
import static co.com.choucair.certificacion.serenityis.utils.EnviromentConstants.ACTOR;
import static co.com.choucair.certificacion.serenityis.utils.EnviromentConstants.ENVIRONMENT_URL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class StarSharpStepDefinitions {

    WebDriver driver;
    private EnvironmentVariables environmentVariables = null;

    @Before
    public void initialConfiguration() {
        //leer la spropiedades del sistema
        ReadProporties.proporties1();
        //configurar webdriver
        WebDriverManager.chromedriver().setup();

        //Map<String, Object> chromePrefs = new HashMap<>();
        //chromePrefs.put("profile.default_content_settings.popups", 0);
        //pasar configuracion al driver
        ChromeOptions options  = new ChromeOptions();
       // options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("start-minimized");
        //WebDriver driver=getDriver();
        //driver.navigate().to("\"www.google.com\"");

        OnStage.setTheStage(new OnlineCast());
        System.out.println();

    }


    @After
    public static <list> void CloseDriver() throws IOException, InterruptedException {
        //cerrar navegador
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
        //cerrartodoslos procesos
        KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
    }

    @Given("I want to schedule a new meet")
    public void iWantToScheduleANewMeet() {
        //OnStage.theActorCalled(ACTOR).wasAbleTo(
                //  Open.url(ENVIRONMENT_URL));
                //Open.url(ENVIRONMENT_URL));

       // Open.url("https://www.ilovepdf.com/es/pdf_a_word"));

        String dev=environmentVariables.getProperty("environments.dev");
        System.out.println("recuperamos la variable del .conf"+dev);

        OnStage.theActorCalled(ACTOR).attemptsTo(
                Open.browserOn().the(LoginPage.class));


        Target elegirarchivo = Target.the("button to submit")
                .located(By.xpath( "//span[contains(text(),'Seleccionar archivo PDF')]"));

        OnStage.theActorCalled(ACTOR).attemptsTo(
                //Open.browserOn().the(LoginPage.class),
                WaitUntil.the(elegirarchivo,
                        isCurrentlyVisible())
                        .forNoMoreThan(01).seconds(),
                Click.on(elegirarchivo));
        //span[contains(text(),'Elegir archivos')]
    }
   @When("login to Startsharp go to schedule it")
    public void loginToStartsharpGoToScheduleIt(DataTable data) {
       System.out.println("CUANDO");
     /*   List<Map<String, String>> newdata = data.asMaps();
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.intoPage(newdata),
                BusinessUnits.menuPage(newdata),
                Meeting.toSchedule(newdata)
        );

      */
    }
    @Then("the virtual meet is correctly created")
    public void theVirtualMeetIsCorrectlyCreated(DataTable data) {
        System.out.println("entonces");

        /*
        List<Map<String, String>> newdata = data.asMaps();
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        IsDifferentMessage.value(GENERATE_MEET,newdata.get(0).get("meetingName"))
                )
        );

         */
    }



}
