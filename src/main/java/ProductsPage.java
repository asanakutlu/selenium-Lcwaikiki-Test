import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.SocketOption;
import java.util.Random;

public class ProductsPage extends BasePage{
  By pricePath=By.xpath("//*[@id='rightInfoBar']//span[@class='price single-price']]");
  By addToCart=By.id("pd_add_to_cart");
  By bodySize=By.xpath("//div[@class='size-pop-up hidden-mobile']//div[@id='option-size']//a[1]");
    public static String price="";
    public ProductsPage(WebDriver driver) {super(driver);}
    public void randomSelectProduct(Logger logger){
        Random random = new Random();
        int randomProduct = random.nextInt(10) + 1;
        WebElement selectProduct=driver.findElement(By.xpath("//div[@class='row c-items']/div["+randomProduct+"]/a"));


        selectProduct.click();
        logger.info("Random 1 ürün seçildi ve tıklanıldı.");
    }
    public void productDetails(Logger logger) throws InterruptedException {
        waitBySecond(4);
        price = driver.findElement(pricePath).getText();
        System.out.println(price);
        click(bodySize);
        logger.info("Beden seçimi yapıldı");
        click(addToCart);
        logger.info("Sepete eklendi");
    }


}
