
package screensframework;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
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
public class fxLogin {

    private String u;
    private String p;
    private boolean sessionValida=false;
    
    private final Label luser = new Label("Usuario: ");
    private final Label lpass = new Label("Contraseña: ");
    private final TextField tfUser = new TextField();
    private final PasswordField tfPass = new PasswordField();
    private final Action actionLogin = new AbstractAction("Login") {
        {  ButtonBar.setType(this, ButtonBar.ButtonType.OK_DONE); }

        /**
         * Este metodo es llamado cuando el boton de login es presionado...
         * @param ae 
         */ 
        public void execute(ActionEvent ae) {
             Dialog dlg = (Dialog) ae.getSource();
                login(tfUser.getText().trim(),tfPass.getText().trim());
             dlg.hide();
        }
    };

    public fxLogin() {
        showLogin();
        u=tfUser.getText().trim();
        p=tfPass.getText().trim();
    }
    
    public String getUser(){
        return u;
    }
    
    public String getPass(){
        return p;
    }
    
    public boolean isSessionValid(){
        return sessionValida;
    }
    
    /**
     * Login de Usuario.
     * @param user
     * @param pass 
     */
    private void login(String user, String pass) {
        if(confirmPass()){
            System.out.println(user+ ": "+pass);
            Dialogs.create().title("Información de Login")
               .masthead("Usuario: "+user)
               .message("Contraseña Correcta!")
            .showInformation();
        }else{
            Dialogs.create().title("Error de Login")
               .masthead("Usuario: "+user)
               .message("Contraseña Incorrecta!\nIntentelo de nuevo.")
            .showError();
        }
    }
    
    /**
     * Registrar nuevo Usuario.
     */
    private void register(String user, String pass, boolean rep) {
        System.out.println(user+ ": "+pass);
        String msg= rep?"Contraseñas Correctas!":"Contraseñas Invalidas!";
        
       Dialogs.create().title("Información")
               .masthead("Usuario: "+user)
               .message(msg)
            .showInformation();
    }
    private void validate(){
        actionLogin.disabledProperty().setValue(
            tfUser.getText().trim().isEmpty() || tfPass.getText().trim().isEmpty()
        );
    }
    
    private void showLogin(){
        Dialog dlg = new Dialog(null, "Login Dialog");
        
        ChangeListener<String> changeListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                validate();
            }
        };
        
        tfUser.textProperty().addListener(changeListener);
        tfPass.textProperty().addListener(changeListener);
        
        final GridPane content = new GridPane();
        content.setHgap(10);
        content.setVgap(10);
        
        content.add(luser, 0, 0);
        content.add(tfUser, 1, 0);
        GridPane.setHgrow(tfUser, Priority.ALWAYS);
        content.add(lpass, 0, 1);
        content.add(tfPass, 1, 1);
        GridPane.setHgrow(tfPass, Priority.ALWAYS);
        
        dlg.setResizable(false);
        dlg.setIconifiable(false);
        //dlg.setGraphic(new ImageView(JavaFXAppTest.class.getResource("login.png").toString()));
        dlg.setContent(content);
        dlg.getActions().addAll(actionLogin, Dialog.Actions.CANCEL);
        validate();
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                tfUser.requestFocus();
            }
        });
        
        dlg.show();
    }

    private boolean confirmPass() {
        String p,r;
        p=tfPass.getText().trim();
        r="12345";
        return p.equals(r);
    }
}
