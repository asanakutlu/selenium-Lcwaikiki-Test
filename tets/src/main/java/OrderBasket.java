
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderBasket extends BasePage {
    By order=By.cssSelector(".header-cart");
    By orderPlus=By.cssSelector(".oq-up");
    By orderDelete=By.xpath("//div[@class='mobile-square-buttons-container']//a[@class='cart-square-link']");
    By delete=By.xpath("//div[@class='col-xs-12']//a[@class='inverted-modal-button sc-delete ins-init-condition-tracking']");
    By productPricecart=By.xpath("//span[@class='rd-cart-item-price mb-15']");
    By orderEmpty=By.cssSelector(".cart-empty-title");
    String orderEmptyText="";
    String priceCart="";
    ProductsPage productsPage=new ProductsPage(driver);
    public OrderBasket(WebDriver driver) {super(driver);}

    public void  orderCart(Logger logger) throws InterruptedException {
        logger.info("Sepet açıldı");
        click(order);
        waitBySecond(5);
        priceCart=driver.findElement(productPricecart).getText().toString();
        logger.info(priceCart);
        waitBySecond(5);
        Assert.assertEquals("Fiyat eşleşmedi",productsPage.price,priceCart);
        logger.info("Fiyat eşleştirildi");
        click(orderPlus);
        waitBySecond(5);
        logger.info("Ürün adeti attırıldı.");
        WebElement number=driver.findElement(By.xpath("//div[@class='item-quantity-editor option-quantity']/input"));
        String adet=number.getAttribute("value");
        Assert.assertEquals("Adet eşleşmedi","2",adet);
        logger.info("Adet eşleştirildi");
        click(orderDelete);
        waitBySecond(5);
        click(delete);
        logger.info("Ürün sepetten silindi");

        orderEmptyText=driver.findElement(orderEmpty).getText();
        Assert.assertEquals("Sepet boşaltılamadı","Sepetinizde ürün bulunmamaktadır.",orderEmptyText);
        logger.info("Sepette ürün bulunmamaktadır");
    }

}
