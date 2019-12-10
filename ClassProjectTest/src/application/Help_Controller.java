package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
// this Scene displays a help message and the button closes the window
public class Help_Controller {

    @FXML
    private Button helpButton;

    @FXML
    void closeHelp(ActionEvent event) {
    	Stage stage = (Stage) helpButton.getScene().getWindow();
    	stage.close();
    }

}

