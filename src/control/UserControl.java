package control;

import bean.UserBean;
import dao.UserDAO;
import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/*
 * Per aprire la pagina di login
 * 1) avviare il server
 * 2) fare il deploy del progetto sul server (senza
 * dimenticare di includere il driver mysql nel build
 * path e renderlo esportabile durante il deploy).
 * 3) visitare il seguente link (eventualmente cambiando
 * il numero di porta dell'application server, il nome
 * del progetto ed il nome della pagina):
 * http://localhost:8080/LoginExample/LoginPage.jsp
 *
 * Per effettuare il deploy del progetto, occorre
 * installare un application server (e.g. Tomcat),
 * crearne un'istanza dentro eclipse e selezionare
 * quali progetti dovranno girare su quella istanza
 * di server.
 * Per rendere esportabile il driver mysql, dopo averlo
 * aggiunto alla build path del progetto, selezionare il
 * tab "order and export" (sempre nella finestra del build
 * path) e spuntare il jar del driver.
 *
 * Se questo non dovesse funzionare (ovvero il caricamento
 * della classe del driver dovesse fallire): Project ->
 * Properties -> Deployment Assembly -> Add -> Project e
 * selezionate il jar.
 *
 * Non dimenticate di creare il database, la tabella e di
 * aggiungere una entry per fare il test (nel progetto
 * trovate lo script sql). Verificare username, password ed
 * URL del db.
 *
 */
public class UserControl {

    private static UserControl instance;

    public static UserControl getInstance() {
        if (instance == null)
            instance = new UserControl();
        return instance;
    }

    private UserControl() {
    }

    /**
     * Carica l'utente corrispondente alla coppia username/password in input
     *
     * @param username username
     * @param password password
     * @return l'utente loggato oppure null se nessun utente corrisponde alla coppia username/password
     */

    //public boolean login(String nickname, String password) {
    //Utente u = UtendeDao.findByNameAndPassword(username, password);
    // return UtendeDao.findByNameAndPassword(nickname, password);
    // }
    public boolean validate(UserBean login) {

        String nickname = login.getNickname();
        String password = login.getPassword();

        UserDAO userDAO = new UserDAO();
        User user = userDAO.verifyUser(nickname, password);
        boolean b = user != null;
        return b;
    }

    @FXML
    public void setControlIndexPam(Stage window, String nick) throws IOException {
        AptManagementControl aptManagementControl = AptManagementControl.getInstance();
        aptManagementControl.initData(window, nick);
    }

}
