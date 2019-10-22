package control;

import boundary.AptManagementBoundary;
import boundary.UserBoundary;
import dao.AptManagementDAO;
import entity.Apartment;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AptManagementControl {

    private static AptManagementControl instance;

    public static AptManagementControl getInstance() {
        if (instance == null)
            instance = new AptManagementControl();
        return instance;
    }

    private AptManagementControl() {
    }

    @FXML
    public void initData(Stage w, String nick) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/boundary/indexPam.fxml"));
        Parent parent = loader.load();
        Scene tableViewScene = new Scene(parent);

        //access the controller and call a method
        AptManagementBoundary controller = loader.getController();
        controller.initiData(nick);

        //This line gets the Stage information
        Stage window = w;
        window.setResizable(false);
        window.setScene(tableViewScene);
        window.setHeight(600);
        window.setWidth(800);
        window.show();
    }

    public void getInformationApt(String nick) {

        List<Apartment> apart = new ArrayList<>();
        Vector<Integer> index = AptManagementDAO.getIdApt(nick);
        for (int i = 0; i<index.size(); i++){
            apart.add(AptManagementDAO.getInformationApt (nick, index.get(i)));
        }
    }




}
