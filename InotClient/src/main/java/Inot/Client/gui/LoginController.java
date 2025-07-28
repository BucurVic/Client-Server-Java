package Inot.Client.gui;

import Inot.Model.PersoanaOficiu;
import Inot.Services.IInotServices;
import Inot.Services.InotException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginController {

    private static final Logger log = LogManager.getLogger(LoginController.class);
    @FXML
    private TextField fieldUsername;
    @FXML
    private PasswordField fieldPassword;

    private Stage stage;
    private IInotServices server;
    private Parent mainParent;
    private MainController mainController;
    private PersoanaOficiu persoanaLogata;

    public void setServer(IInotServices server) {
        this.server = server;
    }
    public void setParent(Parent parent){
        mainParent = parent;
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void handleLogin(ActionEvent actionEvent) throws InotException {
        String username = fieldUsername.getText();
        String password = fieldPassword.getText();
        persoanaLogata = new PersoanaOficiu(username, password, "Cluj-Napoca");

//        if (persoanaLogata == null) {
//            MessageAlert.showErrorMessage(null, "Username incorrect");
//            return;
//        }
//        else if (!password.equals(persoanaLogata.getPassword())) {
//            MessageAlert.showErrorMessage(null, "Password incorrect");
//            return;
//        }

        try {
            server.login(persoanaLogata, mainController);
            System.out.println("Logged in as" + persoanaLogata.getUsername());
            Stage stage = new Stage();
            stage.setTitle("Fereastra Main Inscrieri, logat ca: " + persoanaLogata.getUsername());
            stage.setScene(new Scene(mainParent));
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event){
                    try {
                        mainController.handleLogout();
                    } catch (InotException e) {
                        throw new RuntimeException(e);
                    }
                    System.exit(0);
                }
            });
            stage.show();
            mainController.setPersoanaLogata(persoanaLogata, stage);
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
            fieldUsername.clear();
            fieldPassword.clear();
        } catch (Exception e){
            MessageAlert.showErrorMessage(null, "Login failed" + e.getMessage());
        }
    }

    public void handleExit(){
        Platform.exit();
    }
}
