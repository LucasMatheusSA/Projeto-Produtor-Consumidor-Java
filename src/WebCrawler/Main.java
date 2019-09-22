package WebCrawler;
import ThreadsProdutor.Produtor;
import ThreadsProdutor.ProdutorThread;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ThreadsConsumidor.Consumidor;


public class Main {

    
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread ThreadProdutor = (Thread) new Produtor();
        Thread ThreadConsumidor = (Thread) new Consumidor();
        
        //TESTE DE FUNÇÕES 
        //WebCrawler w = new WebCrawler();
        //w.getImagesLinks("https://pixabay.com/pt/images/search/bob%20esponja/");
        //w.downloadLinks();
        
        ThreadConsumidor.start();
        ThreadProdutor.start();
        
        ThreadProdutor.join();
        ThreadConsumidor.join();
        
    }

}
    