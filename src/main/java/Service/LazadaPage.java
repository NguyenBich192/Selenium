package Service;

import Model.Amazon;
import Model.Lazada;
import Util.baseWeb;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LazadaPage extends baseWeb {

    String search = "//input[@id='q']";
    String btn_search = "//button[normalize-space()='SEARCH']";

    String nameValue = "RfADt";
    String priceValue = "ooOxS";
    String hefValue = "//div[@class='Bm3ON']/div/div/div[2]/div[2]/a";
    static Lazada lazada;
    static List<Lazada> listLazada = new ArrayList<>();

    static List<Amazon> listAmazon = new ArrayList<>();
    AmazonPage amazonPage;

    public void searchIphone() {
        send_key("xpath", search, "Iphone 11");
        click_btn("xpath", btn_search);
    }

    public void getAllProduct() {
        List<WebElement> aPhone = findElements("classname", "Bm3ON");
        List<WebElement> name = findElements("classname", nameValue);
        List<WebElement> hef = findElements("xpath", hefValue);
        List<WebElement> price = findElements("classname", priceValue);

        for (int i = 0; i < aPhone.size(); i++) {
            lazada = new Lazada();
            lazada.setName(name.get(i).getText());
            lazada.setPrice(price.get(i).getText());
            lazada.setLink(hef.get(i).getAttribute("href"));
            listLazada.add(lazada);
        }
        System.out.println(listLazada);
    }

    public void combineList() {
        amazonPage = new AmazonPage();
        listAmazon = amazonPage.getAllProduct();

        System.out.println("listAmazon"+listAmazon+"");

//        ArrayList<Amazon> merge = new ArrayList<>();
        List lstLzd = Arrays.asList(listLazada);
        List lstAmz = Arrays.asList(listAmazon);

        // merging two list using core Java
        List merged = new ArrayList(lstLzd);
        merged.addAll(lstAmz);

        System.out.println("Merged List : " + merged);

        Path output = Paths.get("C:\\Users\\Admin\\Downloads/output.txt");
        try {
            Files.write(output, merged.toString().getBytes());
            System.out.println(output.toFile().getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
