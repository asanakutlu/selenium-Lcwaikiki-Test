import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;


public class loginPage extends BasePage {
    By loginPath=By.xpath("//*[@class='header-section']/div[1]/a");
    By emailInput=By.xpath("//*[@data-tracking-label='GirişEmail']");
    String email="testasanakutlu@gmail.com";
    By passworInput=By.xpath("//*[@data-tracking-label='GirişSifre']");
    String pasword="Test.123";
    By loginButton=By.id("loginLink");
    String Account="";
    By AccountPath=By.xpath("//*[@class='dropdown cart-dropdown']/button/span");
    public loginPage(WebDriver driver) {
        super(driver);
    }
    public void getLoginPage() throws InterruptedException {
    moveToElement(loginPath);
    }
    public void setUser(Logger logger) throws InterruptedException {
        setValue(emailInput,email);
        logger.info("email girisi yapıldı");

        setValue(passworInput,pasword);
        logger.info("sifre girildi");
        click(loginButton);
        Account=driver.findElement(AccountPath).getText();
        Assert.assertEquals("Giriş yapılırken hata oluştu !!","Hesabım",Account);

        logger.info("Giriş İşlemi Başarılı !");
    }
}
