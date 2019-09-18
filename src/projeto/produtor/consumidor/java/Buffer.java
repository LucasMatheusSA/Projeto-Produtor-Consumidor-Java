package projeto.produtor.consumidor.java;

import java.util.ArrayList;
import java.util.List;

public class Buffer {

    private static Buffer instance = null;
    private static List<String> urlList;
    private static int count;


    synchronized public static Buffer getInstance(){
        if(instance == null){
            instance = new Buffer();
            urlList = new ArrayList<String>();
            count = 0;
        }
        return instance;
    }

    synchronized public void insert(String url){
        urlList.add(url);
    }

    synchronized public String getDownload(){
        String aux = null;

        if(urlList != null && urlList.size()>0){
            aux = urlList.remove(0);
        }

        return aux;
    }

    synchronized public void increment(){
        count = count +1;
    }

    synchronized public void decrement(){
        count = count -1;
    }

    synchronized public static int getCount(){
        return count;
    }
    synchronized public static void setCount(int c){
        count = c;
    }

    public static List<String> getURL(){
        return urlList;
    }

    public static void setURL(List<String> url){
        Buffer.urlList = url;
    }

}
