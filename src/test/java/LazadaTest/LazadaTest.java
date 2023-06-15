package LazadaTest;

import Service.AmazonPage;
import Service.LazadaPage;
import Util.baseWeb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LazadaTest extends baseWeb {
    LazadaPage lazadaPage = new LazadaPage();
    AmazonPage amazonPage = new AmazonPage();
    baseWeb baseWeb;

    @Before
    public void beforeTest() {
        baseWeb = new baseWeb();
        baseWeb.open_Browser("chrome");
    }

    @Test
    public void lazadaTest() {
        baseWeb.navigate("https://www.lazada.vn/");
        lazadaPage.searchIphone();
        lazadaPage.getAllProduct();
        lazadaPage.combineList();
    }

    @Test
    public void amazonTest() {
        baseWeb.navigate("https://www.amazon.com/");
        amazonPage.searchIphone();
        amazonPage.getAllProduct();
    }

    @After
    public void AfterTest() {
        baseWeb.close_Browser();
    }
}
