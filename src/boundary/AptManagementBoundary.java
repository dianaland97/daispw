package boundary;

import java.io.IOException;

import bean.AptManagementBean;
import control.AptManagementControl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AptManagementBoundary {

    private AptManagementBean aptManagementBean;
    private AptManagementControl aptManagementControl;

    @FXML
    private TextArea list;

    @FXML
    private TextField textField;

    @FXML
    private Label controlField = new Label();

    @FXML
    private Button ok;

    @FXML
    private Button home;

    @FXML
    private Label information;

    @FXML
    private Button inserisciApt;

    @FXML
    private Button getioneApt;

    @FXML
    private TableView table = new TableView();
    @FXML
    TableColumn idApt = new TableColumn("ID");
    @FXML
    TableColumn statoApt = new TableColumn("Stato");
    @FXML
    TableColumn indirizzoApt = new TableColumn("Indirizzo");
    @FXML
    TableColumn cittaApt = new TableColumn("Città");
    @FXML
    TableColumn provinciaApt = new TableColumn("Provincia");


    public void initiData (String nick){

        information.setText("Benvenuto/a "+ nick);
    }


    //inizializzatore pagina gestioneApt lanciata da indexPam
    public void getList(String nick) {


        aptManagementBean = new AptManagementBean(nick);
        aptManagementControl = AptManagementControl.getInstance();

        boolean checkapt = aptManagementControl.checkIdAndStateApartment(aptManagementBean.getNick());

        if (checkapt == false) {

            this.controlField.setText("Nessun appartamento registrato");
        }

        //table.getColumns().addAll(idApt, statoApt, indirizzoApt, cittaApt, provinciaApt);


        else {


            idApt.setCellValueFactory(new PropertyValueFactory<>("id"));
            statoApt.setCellValueFactory(new PropertyValueFactory<>("state"));
            indirizzoApt.setCellValueFactory(new PropertyValueFactory<>("address"));
            cittaApt.setCellValueFactory(new PropertyValueFactory<>("citys"));
            provinciaApt.setCellValueFactory(new PropertyValueFactory<>("state"));

            aptManagementControl.printInformationAptOnTable(aptManagementBean.getNick(), table);
        }

/*
	     	for (int i=0;i<app.size();i++)
	    	 {
	    	 	if (stato.get(i).equals("Deleted")){
	    	 		 continue;

	    	 	 }
	    	 	else {
	    	 		String[] parts = app.get(i).split(",");
	    	 		Apartment a=new Apartment(parts[0],parts[1],parts[2],parts[3],parts[4]);
	    	 		table.getItems().add(a);

	    	 	}
	    	 		}

        }

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}(\\d{0,4})?")) {
                    textField.setText(oldValue);
                }
            }
        });

 */

    }


    @FXML
    void goToTheNextPage(ActionEvent event) throws IOException {
        //lancio eccezione su campo vuoto
        /*
        try {
            if (!this.textField.getText().isEmpty()) {
                int setId= Integer.parseInt(this.textField.getText());
                gestioneBean.setId(setId);
                boolean validateIndice = gestioneBean.validateIndice();

                //lancio eccezione su inserimento ID errato
                try {
                    if (validateIndice==true) {

                        //System.out.println(setId,this.nickname);

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("VisualizzaApt.fxml"));
                        Parent IndexPamParent = loader.load();
                        Scene tableViewScene = new Scene(IndexPamParent);
                        //access the controller and call a method
                        VisualizzaAptBoundary controller = loader.getController();
                        controller.initData(setId,this.nickname);
                        //This line gets the Stage information
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(tableViewScene);
                        window.setResizable(false);
                        window.show();
                    }
                    else {
                        throw new EditTextException();
                    }}catch(EditTextException exc) {
                    this.controlField.setText(exc.wrongID());}
            }else {
                throw new EditTextException();
            }}catch(EditTextException exc) {
            this.controlField.setText(exc.emptyEditText());}

         */
    }


    @FXML
    void returnHome(ActionEvent event) throws IOException {

        /*
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("IndexPam.fxml"));
        Parent IndexPamParent = loader.load();

        Scene tableViewScene = new Scene(IndexPamParent);

        //access the controller and call a method
        IndexPamBoundary controller = loader.getController();
        controller.initData(gestioneBean.getNick());

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();

         */


    }



    public void GestioneApt (ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/boundary/viewListAptManagement.fxml"));
        Parent IndexPamParent = loader.load();

        Scene tableViewScene = new Scene(IndexPamParent);

        //access the controller and call a method
        //GestioneAptBoundary controller = loader.getController();
        //controller.getList(this.getNickname());

        //This line gets the Stage information
        Stage window = (Stage) this.getioneApt.getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    public void InserisciApt(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("insertApt.fxml"));
        Parent IndexPamParent = loader.load();

        Scene tableViewScene = new Scene(IndexPamParent);

        //access the controller and call a method
        //InserisciAptBoundary controller = loader.getController();
        //controller.init(this.getNickname());

        //This line gets the Stage information
        Stage window = (Stage) this.inserisciApt.getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }
}




