import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    By inputSearch= By.id("search_input");
    By moreProducts=By.cssSelector(".lazy-load-button.lazy-load-button");

    String searchProduct="pantolan";
    public SearchPage(WebDriver driver) {super(driver);}

    public void setInputSearch(Logger logger) throws InterruptedException {
        setValue(inputSearch,searchProduct);
        logger.info("Ürün ismi girildi.");
        inputEnter(inputSearch);
        logger.info("Ürün arandı");
        click(moreProducts);
        logger.info("Daha fazla ürün göstere tıklandı.");
    }

}

