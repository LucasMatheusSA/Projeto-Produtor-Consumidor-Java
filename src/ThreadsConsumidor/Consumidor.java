
package ThreadsConsumidor;

import ThreadsProdutor.Produtor;
import WebCrawler.Buffer;

import java.util.ArrayList;
import java.util.List;


public class Consumidor extends Thread{
    
	int i = 0;
	
    @Override
    public void run(){
    	System.out.println("(Threads Consumidoras start)");
    	Thread downloader1 = new ConsumidorThread("ThreadConsumidor - " + i);
        downloader1.start();i++;
        Thread downloader2 = new ConsumidorThread("ThreadConsumidor - " + i);
        downloader2.start();i++;
        Thread downloader3 = new ConsumidorThread("ThreadConsumidor - " + i);
        downloader3.start();i++;
        Thread downloader4 = new ConsumidorThread("ThreadConsumidor - " + i);
        downloader4.start();i++;
        Thread downloader5 = new ConsumidorThread("ThreadConsumidor - " + i);
        downloader5.start();
    }
    
}