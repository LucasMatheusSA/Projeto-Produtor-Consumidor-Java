package WebCrawler;

import java.util.ArrayList;
import java.util.List;

import ThreadsConsumidor.ConsumidorThread;

public class Buffer {

    private static Buffer instance = null;
    private static ArrayList<String> urlList;
    
    synchronized public static Boolean listIsEmpty(){
    	if(urlList == null) {
    		return true;
    	}else {
    		if(urlList.isEmpty()){
    			return true;
    		}else {
    			return false;
    		}
        }
    }
    synchronized public static Buffer getInstance(){
        if(instance == null){
            instance = new Buffer();
            urlList = new ArrayList<String>();
        }
        return instance;
    }

    synchronized public static void setUrlList(ArrayList<String> urlList) {
    	Buffer.urlList = urlList;
    }

    synchronized public static void setURL(String url){
    	if(urlList == null) {
    		urlList = new ArrayList<String>();
    	}
    	urlList.add(url);
//    	Thread downloader = new ConsumidorThread("Thread" );
//        downloader.start();
//        System.out.println("(Threads Consumidoras start(nova Thread))");
    }

    synchronized public static String getURL(){
        String aux = null;

        if(urlList != null && urlList.size()>0){
            aux = urlList.remove(0);
        }

        return aux;
    }

    synchronized public static ArrayList<String> getURLs(){
    	if(urlList != null) {    	
    		return urlList;
    	}else {
    		urlList = new ArrayList<String>();
    		return urlList;
    	}
    }

    

}