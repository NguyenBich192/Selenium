package LazadaTest;

import Service.AmazonPage;
import Util.baseWeb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AmazonTest {
    AmazonPage amazonPage = new AmazonPage();
    Util.baseWeb baseWeb;

    @Before
    public void beforeTest() {
        baseWeb = new baseWeb();
        baseWeb.open_Browser("chrome");
        baseWeb.getURL("https://www.amazon.com/");
    }

    @Test
    public void test() {
       amazonPage.searchIphone();
       amazonPage.getAllProduct();
    }

    @After
    public void AfterTest() {
        baseWeb.close_Browser();
    }
}
