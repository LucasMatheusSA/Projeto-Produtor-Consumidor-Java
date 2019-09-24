package WebCrawler;

import ThreadsProdutor.Produtor;

public class Semaforo {
	
	synchronized static public Boolean getStatus() {
		if(Produtor.getStauts() == 0 && Produtor.getStatusThread() == false) {
			return false;
		}
		return true;
	}
}
