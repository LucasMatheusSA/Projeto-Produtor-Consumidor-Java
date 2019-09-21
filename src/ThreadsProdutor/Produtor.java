package ThreadsProdutor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Produtor extends Thread{

	private static int status = 0;
	private static boolean statusThread = true;
	
	@Override
	public void run() {
			System.out.println("(Threads Produtoras start)");
            String linha = new String();
            try {
                FileReader aux = new FileReader("/home/lucas/eclipse-workspace/Projeto-Produtor-Consumidor-Java/src/ThreadsProdutor/links.txt");
                BufferedReader arq = new BufferedReader(aux);
                do{
                
                    linha = arq.readLine();
                    if(linha != null){
                    	System.out.println(linha);
                        Thread scraper = new ProdutorThread(linha);
                        scraper.start();status++;
                   	}
                }while (linha != null);
                arq.close();
            } catch (IOException e) {
            }
        }

	synchronized public static void decrement() {
		status -- ;
	}
	
	synchronized public static Boolean statusProdutor() {
		if(status == 0 && statusThread == false) {
			return false;
		}
		return true;
	}

	synchronized public static int getStauts() {
		return status;
	}

	synchronized public void setStauts(int status) {
		this.status = status;
	}

	synchronized public static boolean getStatusThread() {
		return statusThread;
	}

	synchronized public static void setStatusThread(boolean statusThread) {
		statusThread = statusThread;
	}
}