
import org.junit.jupiter.api.Test;


public class Lcwaikikitest extends BaseTest {
    loginPage  loginPage=new loginPage(driver);
    SearchPage searchPage=new SearchPage(driver);
    ProductsPage productsPage=new ProductsPage(driver);
    OrderBasket orderBasket=new OrderBasket(driver);

    @Test
    public void startTest() throws InterruptedException {

        loginPage.getLoginPage();
        loginPage.setUser(logger);
        searchPage.setInputSearch(logger);
        productsPage.randomSelectProduct(logger);
        productsPage.productDetails(logger);
        orderBasket.orderCart(logger);

    }


}
