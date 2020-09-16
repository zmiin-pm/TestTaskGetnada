import Driver.DriverHolder;
import Pages.PicturePage;
import Pages.TempMailPage;
import io.restassured.response.Response;
import org.testng.annotations.*;

import java.util.List;

public class BaseTest {

    protected String randomCat, randomDog, randomFox, tempMailAddress;
    protected Response responseRandomCat, responseRandomDog, responseRandomFox;
    protected TempMailPage tempMailPage;
    protected List<String> linksFromMail;

    @BeforeSuite
    public void beforeSuite() {
        DriverHolder.INSTANCE.initDriver(
                10,  // implicitly
                30); // explicitly
    }

    @AfterClass
    public void afterClass() {
        new PicturePage()
                .open(linksFromMail.get(0))
                .TakeAndSaveScr("Cat")
                .open(linksFromMail.get(1))
                .TakeAndSaveScr("Dog")
                .open(linksFromMail.get(2))
                .TakeAndSaveScr("Fox");
    }

    @AfterSuite
    public void afterSuite() {
        DriverHolder.INSTANCE.getDriver().quit();
    }
}
