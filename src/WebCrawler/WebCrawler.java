package WebCrawler;

import java.awt.image.BufferedImage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;


public class WebCrawler {

   public static void downloadLinks(){
	   int i=0;
       try {
           for(String link : Buffer.getURLs()){
               InputStream in = new URL(link).openStream();
               
               Files.copy(in,Paths.get("/home/lucas/Pictures/testeTrabalho/img" + i + ".png"));
               in.close();
               System.out.println("img"+ i +" (baixada)("+link+")");
               i ++;
           }
       } catch (Exception e) {
       }
    }
   
   public void getImagesLinks(String link) throws IOException {
        int i=0;
        Document doc = Jsoup.connect(link).get();
        Elements linksImg = doc.getElementsByTag("img");
        for(Element img : linksImg){
        	Buffer.setURL(img.attr("src"));
        }
        System.out.println("urls-"+Buffer.getURLs());
    }
}

