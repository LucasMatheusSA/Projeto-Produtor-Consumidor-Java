
package ThreadsConsumidor;

import ThreadsProdutor.Produtor;
import WebCrawler.Buffer;

import java.util.ArrayList;
import java.util.List;


public class Consumidor extends Thread{
    
	int i = 0;
	
    @Override
    public void run(){
    	Thread downloader = new ConsumidorThread("Thread-" + i);
        downloader.start();
        System.out.println("(Threads Consumidoras start)");
    }
    
}