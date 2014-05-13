package screensframework;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import org.controlsfx.control.ButtonBar;
import org.controlsfx.control.action.AbstractAction;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 * 
 * @author Adrianlrx <adrianlrx@gmail.com>
 */
public class RunScreens extends Application {
    /**
     * Primera Pantalla amostrar
     */
    public static String screen1ID = "Principal";
    public static String screen2ID = "Configuracion";
    public static String screen3ID = "Privados";
    public static String screen4ID = "Publicos";
    
    public static String screen1File = "Screen1.fxml";
    public static String screen2File = "Screen2.fxml";
    public static String screen3File = "Screen3.fxml";
    public static String screen4File = "Screen4.fxml";
    
    fxLogin login;
    
    /**
     * Start Stage
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        //login = new fxLogin();
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(RunScreens.screen1ID, RunScreens.screen1File);/*
        mainContainer.loadScreen(RunScreens.screen2ID, RunScreens.screen2File);
        mainContainer.loadScreen(RunScreens.screen3ID, RunScreens.screen3File);
        // */
        mainContainer.setScreen(RunScreens.screen1ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylefx.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Firma Digital.");
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
