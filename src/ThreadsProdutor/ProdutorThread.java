package ThreadsProdutor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ThreadsConsumidor.ConsumidorThread;
import WebCrawler.Buffer;
import WebCrawler.WebCrawler;




public class ProdutorThread extends Thread{
    
        String link = new String();
        
        static int num = 0;
        
        public ProdutorThread(String link){
            this.link = link;
        }
	
        synchronized public void increment() {
        	num++;
        }
        
	@Override
	public void run() {
            int i=0;
	    try{
	        Document doc = Jsoup.connect(link).get();
	        ArrayList<String> Urls = new ArrayList<String>();
	        Elements linksImg = doc.getElementsByTag("img");
	        for(Element img : linksImg){
	            Buffer.setURL("https:"+img.attr("src"));
	        }
            System.out.println("(URLs Threads)-"+Buffer.getURLs());
            } catch (IOException e) {
            }
        	Produtor.decrement();
        	if(Produtor.getStauts() == 0) {
        		Produtor.setStatusThread(false);
        	}
        	System.out.println(Produtor.getStatusThread());
        }
	
}