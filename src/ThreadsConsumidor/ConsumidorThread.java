
package ThreadsConsumidor;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import ThreadsProdutor.Produtor;
import WebCrawler.Buffer;


public class ConsumidorThread extends Thread{
	
	String name = new String();
	
	public ConsumidorThread(String name) {
		this.name = name;
	}
    
    
    @Override
    public void run(){
    	int i=0;
        while(!Buffer.listIsEmpty() || Produtor.statusProdutor()){
            try {
            	
                String link = Buffer.getURL();
                InputStream in = new URL(link).openStream();
                
                Files.copy(in,Paths.get("/home/lucas/Pictures/testeTrabalho/img" + i + name +".png"));
                in.close();
                System.out.println("img"+ i +" (baixada pela "+ name +")("+link+")");
                i++;
            	
            } catch (Exception e) {
            }
        }
        System.out.println("Final da " + name);
    }
}