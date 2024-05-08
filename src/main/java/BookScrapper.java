import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BookScrapper {
    public static void main(String[] args) {
        String url = "https://books.toscrape.com/";

        try {
            Document document = Jsoup.connect(url).get();
            Elements books = document.select(".product_pod");

            System.out.println("========================================");
            System.out.println("Boks - Web Scrapper");
            System.out.println("========================================");
            for (Element bk:books) {
                String title= bk.select("h3 > a").text();
                String price= bk.select(".price_color").text();

                String actual_price = price.substring(1);
                //System.out.println("Title: " + title+"\nPrice: " + price);

                if (Double.parseDouble(actual_price)<20){
                    System.out.println("Title: " + title+"\nPrice: " + price);
                    System.out.println("------------------------------------");
                }
            };
            System.out.println("========================================");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
