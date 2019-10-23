package threadAndException;
import java.util.List;
import java.util.Vector;

import entity.Apartment;
import javafx.scene.control.TableView;

public class DownloaderThreadApt implements Runnable{

	private String nick;
	private TableView table;
	private List<Apartment> apt;

	public DownloaderThreadApt (List<Apartment> apt, String nickname, TableView<?> table) {
		
		this.nick = nickname;
		this.table = table;
		this.apt = apt;
		
	}
	
	public void run() {


		for (int i=0; i<apt.size(); i++)
   	 	{		
   	 	if (apt.get(i).getState().equals("Deleted")){
   	 		 continue; 
   	 		 }
   	 	else {
   	 		//String[] parts = apt.get(i);;
   	 		table.getItems().add(String.valueOf(apt.get(i).getId()));
   	 		}
   	 	}
	}

}
