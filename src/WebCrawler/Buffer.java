package WebCrawler;

import java.util.ArrayList;
import java.util.List;

import ThreadsConsumidor.ConsumidorThread;

public class Buffer {

    private static Buffer instance = null;
    private static ArrayList<String> urlList = new ArrayList<String>();
    
    synchronized public static Boolean listIsEmpty(){ // Checar se o Buffer esta vazio 
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
    
    synchronized public static Buffer getInstance(){ // Instanciar o Buffer 
        if(instance == null){
            instance = new Buffer();
            urlList = new ArrayList<String>();
        }
        return instance;
    }

    synchronized public static void setUrlList(ArrayList<String> urlList) { // Colocar uma lista de Urls no Bufer
    	Buffer.urlList = urlList;
    }

    synchronized public static void setURL(String url){ // Colocar apenas uma Url no Buffer 
    	if(urlList == null) {
    		urlList = new ArrayList<String>();
    	}
    	urlList.add(url);
    }

    synchronized public static String getURL(){ // Pegar apenas uma Url do Buffer
        if(urlList != null && urlList.size()>0){
            return urlList.remove(0);
        }
        return null;
    }

    synchronized public static ArrayList<String> getURLs(){ // Pegar todas as Urls do Buffer
    	if(urlList != null) {    	
    		return urlList;
    	}else {
    		urlList = new ArrayList<String>();
    		return urlList;
    	}
    }

    

}