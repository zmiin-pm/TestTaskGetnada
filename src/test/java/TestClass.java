import API.RestApi;
import Driver.DriverHolder;
import Gmail.MailSender;
import Pages.TempMailPage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.jsoup.Connection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class TestClass extends BaseTest{

    @Test
    public void firstTest(){
        TempMailPage tempMailPage = new TempMailPage()
                .open("https://getnada.com");
        String tempMailAddress = tempMailPage.getMailAddress();
        String randomCat =  RestApi.getLink(
                RestApi.sendGetRequest("https://aws.random.cat/meow"));
        String randomDog =  RestApi.getLink(
                RestApi.sendGetRequest("https://random.dog/woof.json"));
        String randomFox =  RestApi.getLink(
                RestApi.sendGetRequest("https://randomfox.ca/floof/"));
        String mailBody =  randomCat + "\n"
                + randomDog + "\n"
                + randomFox + "\n";
        MailSender ms = new MailSender();
        ms.mailSend(tempMailAddress, mailBody);
        List<String> list = tempMailPage.openMail().getMessageFromMail();
        Assert.assertEquals(list.get(0), randomCat );
        Assert.assertEquals(list.get(1), randomDog);
        Assert.assertEquals(list.get(2), randomFox);
    }

}

