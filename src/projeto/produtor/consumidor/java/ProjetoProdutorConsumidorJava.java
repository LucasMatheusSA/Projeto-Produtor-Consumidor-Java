package projeto.produtor.consumidor.java;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ProjetoProdutorConsumidorJava {

    
    public static void main(String[] args) {
        WebCrawler w = new WebCrawler();
        w.getImagesLinks("https://stackoverflow.com");
        
        System.out.println(Buffer.getURL());
        w.download();
    }

}
    
