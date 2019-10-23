package boundary;
import java.io.IOException;

import bean.UserBean;
import control.UserControl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import threadAndException.EditTextException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserBoundary {

    UserBean userPam;
    UserControl controlLogin;

    @FXML
    private ImageView image;

    @FXML
    private TextField user;

    @FXML
    private PasswordField pass;

    @FXML
    private Button log;

    @FXML
    private Button reset;

    @FXML
    private Label info;

    @FXML
    private Label information;
    //hello babyyyyy
    //yoh

    @FXML
    void clear(ActionEvent event) {
        user.setText("");
        pass.setText("");
        info.setText("Accedi");
    }

   @FXML
    public void initialize(){
        image.setImage(new Image(getClass().getResource("/Logo.png").toString(), true));
    }

    @FXML
    void login(ActionEvent event) throws IOException {

        userPam= new UserBean(user.getText().toString(),pass.getText().toString());
        controlLogin = UserControl.getInstance();
        boolean validate = controlLogin.validate(userPam);

        try {
            if (validate == false ) {
                throw new EditTextException();
            }
            else {
                controlLogin.setControlIndexPam((Stage) ((Node)event.getSource()).getScene().getWindow(), userPam.getNickname());
            }}catch(EditTextException exc) {
            info.setText(exc.wrongData());
        }
    }

    public void initiData (UserBean userPam){
        information.setText("Benvenuto/a "+ userPam.getNickname());
    }

}
