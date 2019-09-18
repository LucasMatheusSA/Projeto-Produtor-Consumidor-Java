package projeto.produtor.consumidor.java;

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

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

public class WebCrawler {


   private String s;
   
   public void getImagesLinks(String url){
       Buffer urlBuffer = Buffer.getInstance();
       try{
             Document doc = Jsoup.connect("https://stackoverflow.com").get();
             ArrayList<String> Urls = new ArrayList<String>();
             Elements linksPage = doc.getElementsByTag("img");
       
        
            for(Element img : linksPage){
                Urls.add(img.attr("src"));
                urlBuffer.increment();
            }
           
            urlBuffer.setURL(Urls);
       } catch (IOException e) {
       }
   }

   public void download(){
       int i=0;
       try {
           for(String link : Buffer.getURL()){
               InputStream in = new URL(link).openStream();
               
               Files.copy(in,Paths.get("C:\\Users\\suporte\\Pictures\\testeProjeto" + i + ".png"));
               in.close();
           }
       } catch (Exception e) {
       }
       //FUNÇÂO ORIGINAL
       //Buffer urlBuffer = Buffer.getInstance();
       //String image = null;
       //
       //if(!urlBuffer.getURL().isEmpty()){
       //
       //    image = urlBuffer.getDownload();
       //    try{
       //        InputStream in = new URL(image).openStream();
       //        Files.copy(in , Paths.get("C:\\Users\\Ingrid\\Documents\\NetBeansProjects\\wc\\Image.txt"+ Math.random()));
       //        in.close();
       //    } catch (MalformedURLException e) {
       //        e.printStackTrace();
       //    } catch (IOException e) {
       //        e.printStackTrace();
       //    }
       //}
    }

   public boolean eURL(String url) throws MalformedURLException {
       URL u = new URL(url);
       try{
           u.openStream().close();
           return true;
       } catch (IOException e) {
           return false;
       }
   }
}


