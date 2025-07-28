package Inot.Client;

import Inot.Client.gui.LoginController;
import Inot.Client.gui.MainController;
import Inot.Network.proto.InotServicesGrpcProxy;
//import Inot.Network.proto.InotServicesProtoProxy;
import Inot.Network.rpcprotocol.InotServicesRpcProxy;
import Inot.Services.IInotServices;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class StartRpcClient extends Application {
    private Stage primaryStage;

    private static int defaultInotPort = 55555;
    private static String defaultServer = "localhost";

    private static Logger logger = LogManager.getLogger(StartRpcClient.class);

    public void start(Stage primaryStage) throws Exception {
        logger.debug("In start");
        Properties clientProps = new Properties();
        try {
            clientProps.load(StartRpcClient.class.getResourceAsStream("/inotclient.properties"));
            logger.info("Client properties set {} ", clientProps);
            // clientProps.list(System.out);
        } catch (IOException e) {
            logger.error("Cannot find chatclient.properties " + e);
            logger.debug("Looking into folder {}", (new File(".")).getAbsolutePath());
            return;
        }
        String serverIP = clientProps.getProperty("inot.server.host", defaultServer);
        int serverPort = defaultInotPort;

        try {
            serverPort = Integer.parseInt(clientProps.getProperty("inot.server.port"));
        } catch (NumberFormatException ex) {
            logger.error("Wrong port number " + ex.getMessage());
            logger.debug("Using default port: " + defaultInotPort);
        }
        logger.info("Using server IP " + serverIP);
        logger.info("Using server port " + serverPort);

        IInotServices server = new InotServicesRpcProxy(serverIP, serverPort);
//        IInotServices server = new InotServicesGrpcProxy(serverIP, serverPort);

        FXMLLoader loader = new FXMLLoader(
                getClass().getClassLoader().getResource("views/Login-view.fxml"));
        Parent root=loader.load();
        LoginController ctrl =
                loader.getController();
        ctrl.setServer(server);

        FXMLLoader cloader = new FXMLLoader(
                getClass().getClassLoader().getResource("views/Main-view.fxml"));
        Parent croot=cloader.load();

        MainController inotCtrl =
                cloader.getController();
        inotCtrl.setServer(server);

        ctrl.setMainController(inotCtrl);
        ctrl.setParent(croot);

        primaryStage.setTitle("Fereastra Login");
        primaryStage.setScene(new Scene(root, 390, 290));
        primaryStage.show();
    }
}
