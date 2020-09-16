import Driver.DriverHolder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    @BeforeSuite
    public void beforeSuite() {
        DriverHolder.INSTANCE.initDriver(
                10,  // implicitly
                500); // explicitly
    }

    @AfterSuite
    public void afterSuite() {
//        DriverHolder.INSTANCE.getDriver().quit();
    }
}
