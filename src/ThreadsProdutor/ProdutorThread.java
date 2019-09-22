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
        String nome = new String();
        static int num = 0;
        
        public ProdutorThread(String link,String nome){
            this.link = link;
            this.nome = nome;
        }
	
        synchronized public void increment() {
        	num++;
        }
        
	@Override
	public void run() { // Vai ao link pega os links da imagens e quarda no Buffer 
            int i=0;
	    try{
	        Document doc = Jsoup.connect(link).get();
	        Elements linksImg = doc.getElementsByTag("img");
	        
	        for(Element img : linksImg){
	            Buffer.setURL("https:" + img.attr("src"));
	            System.out.println(nome + ":(imagem)-https:" + img.attr("src"));
	        }
	        
            System.out.println("(Final da " + nome + ")-" + Buffer.getURLs());
            
            } catch (IOException e) {
            }
	    
        	Produtor.decrement();
        	
        	if(Produtor.getStauts() == 0) {
        		Produtor.setStatusThread(false);
        	}
        	
        	System.out.println(Produtor.getStatusThread());
        }
	
}