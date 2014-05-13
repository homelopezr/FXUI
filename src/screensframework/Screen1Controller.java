package screensframework;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Adrianlrx <adrianlrx@gmail.com>
 */
public class Screen1Controller implements Initializable, ControlledScreen {
    
    ScreensController myController;
    
    @FXML
    private ResourceBundle bundle;
    
    @FXML
    private AnchorPane anchor;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label lblTitulo;
    @FXML
    private Button btnConfig;
    @FXML
    private Button btnprivado;
    @FXML
    private Button btnPublico;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnBusca1;
    @FXML
    private Button btnBusca2;
    @FXML
    private Button btnBusca3;
    @FXML
    private Button btnFirmar;
    @FXML
    private Button btnVerificar;
    @FXML
    private TextField tfArchivo;
    @FXML
    private TextField tfFirma;
    @FXML
    private TextField tfFirmante;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Local: "+Locale.getDefault().getDisplayLanguage()
                + "_"+Locale.getDefault().getCountry());
        bundle = rb;
    }    

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @FXML
    private void actionConfig(ActionEvent event) {
        System.out.println("Configuracion");
    }

    @FXML
    private void actionPrivados(ActionEvent event) {
        System.out.println("Privados");
    }

    @FXML
    private void actionPublicos(ActionEvent event) {
        System.out.println("Publicos");
    }

    @FXML
    private void actionSalir(ActionEvent event) {
        System.out.println("Salir");
        System.exit(0);
    }

    @FXML
    private void actionBusca1(ActionEvent event) {
        System.out.println("Busca1");
        tfArchivo.setText("Buscar1");
        
    }

    @FXML
    private void actionBusca2(ActionEvent event) {
        System.out.println("Busca2");
        tfFirma.setText("Buscar2");
    }

    @FXML
    private void actionBusca3(ActionEvent event) {
        System.out.println("Busca3");
        tfFirmante.setText("Buscar3");
    }

    @FXML
    private void actionFirmar(ActionEvent event) {
        System.out.println("Firmar");
    }

    @FXML
    private void actionVerificar(ActionEvent event) {
        System.out.println("Verificar");
    }
    
    
}
