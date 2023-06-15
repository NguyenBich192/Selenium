package Service;

import Model.Amazon;
import Util.baseWeb;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class AmazonPage extends baseWeb {
    String search = "//input[@id='twotabsearchtextbox']";
    String btn_search = "//input[@id='nav-search-submit-button'][1]";
    String passWeb = "//div[@Class=\"a-column a-span6 a-span-last a-text-right\"]";
    String nameValue = "//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']";
    String priceValue = "//div[@class='a-section a-spacing-none a-spacing-top-micro puis-price-instructions-style']/div/a/span/span[2]/span[2]";
    String hrefValue = "//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/h2/a";
    String listPhone = "//div[@data-component-type=\"s-search-result\"]";
    String file = "//div[@class='a-row a-text-center']/img";

    static Amazon amazon;

    static List<Amazon> listAmazon = new ArrayList<>();

    public void searchIphone() {
        WebElement check = findElement("xpath", passWeb);
        Boolean clickImage = check.isDisplayed();
        if (clickImage == true) {
            click_btn("xpath", passWeb);
        }
//        String srcFile = findElement("xpath", file).getAttribute("src");
//        System.out.println(crackImage(srcFile));
        send_key("xpath", search, "Iphone 11");
        click_btn("xpath", btn_search);
    }

    public List<Amazon> getAllProduct() {
        List<WebElement> aPhone = findElements("xpath", listPhone);
        List<WebElement> name = findElements("xpath", nameValue);
        List<WebElement> hef = findElements("xpath", hrefValue);
        List<WebElement> price = findElements("xpath", priceValue);

        for (int i = 0; i < aPhone.size(); i++) {
            amazon = new Amazon();
            amazon.setName(name.get(i).getText());
            amazon.setPrice(price.get(i).getText());
            amazon.setLink(hef.get(i).getAttribute("href"));
            listAmazon.add(amazon);
        }
        System.out.println(listAmazon);
        return listAmazon;
    }


}
