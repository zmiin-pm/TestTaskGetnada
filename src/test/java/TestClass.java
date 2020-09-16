import API.RestApi;
import Gmail.MailSender;
import Pages.TempMailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseTest {

    @Test(priority = 0)
    public void sendGetRequestAndGetResponseRandomCat() {
        responseRandomCat = RestApi.sendGetRequest("https://aws.random.cat/meow");
        Assert.assertEquals(responseRandomCat.getStatusCode(), 200);
    }

    @Test(priority = 1)
    public void sendGetRequestAndGetResponseRandomDog() {
        responseRandomDog = RestApi.sendGetRequest("https://random.dog/woof.json");
        Assert.assertEquals(responseRandomDog.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void sendGetRequestAndGetResponseRandomFox() {
        responseRandomFox = RestApi.sendGetRequest("https://randomfox.ca/floof/");
        Assert.assertEquals(responseRandomFox.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void createTempMail() {
        tempMailPage = new TempMailPage()
                .open("https://getnada.com");
        tempMailAddress = tempMailPage.getMailAddress();
        Assert.assertTrue(!tempMailAddress.isEmpty(), "Mail address is empty");
    }

    @Test(priority = 4)
    public void getLinksFromResponses() {
        randomCat = RestApi.getLink(responseRandomCat);
        randomDog = RestApi.getLink(responseRandomDog);
        randomFox = RestApi.getLink(responseRandomFox);
        Assert.assertTrue(!randomCat.isEmpty(), "Cat link is empty");
        Assert.assertTrue(!randomDog.isEmpty(), "Dog link is empty");
        Assert.assertTrue(!randomFox.isEmpty(), "Fox link is empty");
    }

    @Test(priority = 5)
    public void sendMailRecieveMailCompareLinks() {
        String mailBody = randomCat + "\n"
                + randomDog + "\n"
                + randomFox + "\n";
        new MailSender().mailSend(tempMailAddress, mailBody);
        linksFromMail = tempMailPage.openMail().getMessageFromMail();
        Assert.assertEquals(linksFromMail.get(0), randomCat);
        Assert.assertEquals(linksFromMail.get(1), randomDog);
        Assert.assertEquals(linksFromMail.get(2), randomFox);
    }
}

